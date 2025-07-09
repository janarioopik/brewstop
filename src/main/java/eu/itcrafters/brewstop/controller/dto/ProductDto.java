package eu.itcrafters.brewstop.controller.dto;

import eu.itcrafters.brewstop.infrastructure.persistence.product.Product;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;

/**
 * DTO for {@link Product}
 */

@Data
public class ProductDto {

    @NotNull
    @Size(max = 10)
    @NotEmpty
    private String name;
    @NotNull
    private BigDecimal price;
    private String categoryName;
}