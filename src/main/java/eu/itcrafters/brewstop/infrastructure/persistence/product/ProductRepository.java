package eu.itcrafters.brewstop.infrastructure.persistence.product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}