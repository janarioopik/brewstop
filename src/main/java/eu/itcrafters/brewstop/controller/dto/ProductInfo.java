package eu.itcrafters.brewstop.controller.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * DTO for {@link eu.itcrafters.brewstop.infrastructure.persistence.Product}
 */

@Data
@EqualsAndHashCode(callSuper = true)
@ToString
public class ProductInfo extends ProductDto {
    private Integer id;


}