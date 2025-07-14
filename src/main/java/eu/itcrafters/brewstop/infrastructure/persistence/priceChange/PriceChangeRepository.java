package eu.itcrafters.brewstop.infrastructure.persistence.priceChange;

import org.hsqldb.lib.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceChangeRepository extends JpaRepository<PriceChange, Integer> {
    List<PriceChange> findByProductIdOrderByChangedAtDesc(Integer productId);
}