package eu.itcrafters.brewstop.controller.dto;

import eu.itcrafters.brewstop.infrastructure.persistence.product.Product;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * DTO for {@link Product}
 */

@Data
@EqualsAndHashCode(callSuper = true)
@ToString
public class ProductInfo extends ProductDto {
    private Integer id;
}