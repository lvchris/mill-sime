package fr.ippon.mill.farmer.domain;

import fr.ippon.mill.farmer.infrastructure.secondary.DeliveryEntity;
import fr.ippon.mill.farmer.infrastructure.secondary.DeliveryEntityRepository;
import fr.ippon.mill.farmer.infrastructure.secondary.JpaFarmerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DeliveryService {

  @Autowired
  JpaFarmerRepository jpaFarmerRepository;

  @Autowired
  DeliveryEntityRepository deliveryEntityRepository;

  DeliveryService createDelivery(Farmer farmer, LocalDate deliveryDate, String cropType) throws Exception {

    if(farmer.getReference() == null || jpaFarmerRepository.findByReference(farmer.getReference()).isEmpty()) {
      throw new Exception("Farmer not found");
    }

    if(deliveryDate.isBefore(LocalDate.now().plusDays(7))) {
      throw new Exception("Date non conform");
    }

    CropType.verifyCropTypeAndCast(cropType);

    DeliveryEntity deliveryEntity = new DeliveryEntity();
    deliveryEntity.setFarmer(jpaFarmerRepository.findByReference(farmer.getReference()).get());
    deliveryEntity.setDeliveryDate(java.sql.Date.valueOf(deliveryDate));
    deliveryEntity.setCropType(CropType.verifyCropTypeAndCast(cropType));

    deliveryEntityRepository.save(deliveryEntity);
    return this;
  }

}
