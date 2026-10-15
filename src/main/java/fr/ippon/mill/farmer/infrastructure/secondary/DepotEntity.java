package fr.ippon.mill.farmer.infrastructure.secondary;


import fr.ippon.mill.farmer.domain.Mill;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.springframework.data.annotation.Id;

import java.util.Date;

public class DepotEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "farmer")
  private Long farmer_id;
  @Column(nullable = false)
  private Mill mill;
  @Column(nullable = false)
  private Date order_date;
  @Column(nullable = false)
  private Date delivery_date;
}
