package eu.itcrafters.brewstop.infrastructure.rest.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Error {

    NO_PRODUCT_EXISTS("Product not found"),

    NO_CATEGORY_EXISTS("Category not found");

    private final String message;
}
