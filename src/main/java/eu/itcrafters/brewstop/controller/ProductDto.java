package eu.itcrafters.brewstop.controller;

import eu.itcrafters.brewstop.infrastructure.persistence.Category;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO for {@link eu.itcrafters.brewstop.infrastructure.persistence.Product}
 */
@Value
public class ProductDto implements Serializable {
    Integer id;
    @NotNull
    @Size(max = 100)
    String name;
    @NotNull
    BigDecimal price;
    @NotNull
    Category category;
}