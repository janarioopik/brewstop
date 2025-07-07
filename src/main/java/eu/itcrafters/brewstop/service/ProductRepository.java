package eu.itcrafters.brewstop.service;

import eu.itcrafters.brewstop.infrastructure.persistence.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}