package eu.itcrafters.brewstop.controller.dto;

import eu.itcrafters.brewstop.infrastructure.persistence.Category;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;


import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO for {@link eu.itcrafters.brewstop.infrastructure.persistence.Product}
 */

@Data
public class ProductDto {
    private Integer id;
    private String  name;
    private BigDecimal price;
    private Integer categoryId;
    private String  categoryName;
}