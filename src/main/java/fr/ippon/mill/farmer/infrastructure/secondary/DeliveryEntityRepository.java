package fr.ippon.mill.farmer.infrastructure.secondary;


import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryEntityRepository extends JpaRepository<DeliveryEntity, Long> {

}
