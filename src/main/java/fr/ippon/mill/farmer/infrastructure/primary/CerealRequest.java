package fr.ippon.mill.farmer.infrastructure.primary;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.UUID;

public class CerealRequest {
  public CerealType getType() {
    return type;
  }

  public UUID getFarmerId() {
    return farmerId;
  }

  public Date getDeliveryDate() {
    return deliveryDate;
  }

  public double getQuantity() {
    return quantity;
  }

  public enum CerealType {
    Ble,
    Avoine,
    Houblon,
    Orge
  }

  @JsonProperty("cereal")
  @NotNull
  @NotBlank
  private CerealType type;

  @JsonProperty("farmerId")
  @NotNull
  @NotBlank
  private UUID farmerId;

  @JsonProperty("deliveryDate")
  @NotNull
  @NotBlank
  private Date deliveryDate;

  @JsonProperty("quantity")
  @NotNull
  @NotBlank
  private double quantity;
}
