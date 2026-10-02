package fr.ippon.mill.farmer.infrastructure.secondary;

import fr.ippon.mill.farmer.domain.CropType;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "delivery")
@SequenceGenerator(name = "seq_delivery", allocationSize = 1)
public class DeliveryEntity {

  @Id
  @GeneratedValue(strategy = jakarta.persistence.GenerationType.SEQUENCE, generator = "seq_delivery")
  Long id;

  @ManyToOne
  @JoinColumn(name = "farmer_id")
  FarmerEntity farmer;

  Date deliveryDate;

  @Enumerated(EnumType.STRING)
  CropType cropType;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public FarmerEntity getFarmer() {
    return farmer;
  }

  public void setFarmer(FarmerEntity farmer) {
    this.farmer = farmer;
  }

  public Date getDeliveryDate() {
    return deliveryDate;
  }

  public void setDeliveryDate(Date deliveryDate) {
    this.deliveryDate = deliveryDate;
  }

  public CropType getCropType() {
    return cropType;
  }

  public void setCropType(CropType cropType) {
    this.cropType = cropType;
  }
}
