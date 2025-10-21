package fr.ippon.mill.farmer.infrastructure.primary;

import fr.ippon.mill.farmer.domain.Farmer;
import fr.ippon.mill.farmer.domain.FarmerAlreadyExistsException;
import fr.ippon.mill.farmer.domain.FarmerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@Validated
public class FarmerRessource {

  public static final String FARMER_API_URI = "/api/farmers";

  public static final String CEREAL_API_URI = "/api/cereals";

  private final FarmerService farmerService;

  public FarmerRessource(FarmerService farmerService) {
    this.farmerService = farmerService;
  }

  @PostMapping
  @RequestMapping(FarmerRessource.FARMER_API_URI)
  public ResponseEntity<Void> createFarmer(@RequestBody @Valid CreateFarmerRequest newFarmer) {
    Farmer farmer = Farmer.create(newFarmer.getFirstName(), newFarmer.getLastName(), newFarmer.getEmail(), newFarmer.getPhoneNumber());
    try {
      String reference = farmerService.register(farmer);
      String locationUri = String.format("%s/%s", FARMER_API_URI, reference);
      return ResponseEntity.created(URI.create(locationUri)).build();
    } catch (FarmerAlreadyExistsException farmerAlreadyExistsException) {
      return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }
  }

  @PostMapping
  @RequestMapping(FarmerRessource.CEREAL_API_URI)
  public ResponseEntity<Void> createCereals(@RequestBody @Valid CerealRequest cerealRequest) {
  }
}
