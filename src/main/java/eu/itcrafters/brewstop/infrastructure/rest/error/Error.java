package eu.itcrafters.brewstop.infrastructure.rest.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Error {
    NO_PRODUCT_EXISTS("Product not found");

    private final String message;
}
