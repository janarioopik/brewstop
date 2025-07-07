package eu.itcrafters.brewstop.controller.dto;

import eu.itcrafters.brewstop.infrastructure.persistence.product.Product;
import lombok.Data;

import java.math.BigDecimal;

/**
 * DTO for {@link Product}
 */

@Data
public class ProductDto {

    private String name;
    private BigDecimal price;
    private String categoryName;
}