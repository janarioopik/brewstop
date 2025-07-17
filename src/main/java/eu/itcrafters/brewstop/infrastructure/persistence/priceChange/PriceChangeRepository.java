package eu.itcrafters.brewstop.infrastructure.persistence.priceChange;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PriceChangeRepository extends JpaRepository<PriceChange, Integer> {
    List<PriceChange> findByProductIdOrderByChangedAtDesc(Integer productId);
}