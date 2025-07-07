package eu.itcrafters.brewstop.controller.dto;

import eu.itcrafters.brewstop.infrastructure.persistence.Category;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO for {@link eu.itcrafters.brewstop.infrastructure.persistence.Product}
 */

@Data
public class ProductDto implements Serializable {
    private Integer id;
    @NotNull
    @Size(max = 100)
    private String name;
    @NotNull
    private BigDecimal price;
    @NotNull
    private Category category;
}