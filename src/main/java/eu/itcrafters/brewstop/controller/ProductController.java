package eu.itcrafters.brewstop.controller;

import eu.itcrafters.brewstop.controller.dto.ProductDto;
import eu.itcrafters.brewstop.infrastructure.rest.error.ApiError;
import eu.itcrafters.brewstop.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //@GetMapping
    //public List<ProductDto> all() {return productService.getAll();}


    @GetMapping("/product/{productid}")
    @Operation(summary = "Finds product by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "ok"),
            @ApiResponse(responseCode = "404", description = "Product not exist",
            content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public ProductDto findProduct(@PathVariable Integer id) {
       return productService.findProduct(id);
    }
}
