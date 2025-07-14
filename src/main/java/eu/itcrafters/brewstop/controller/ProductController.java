package eu.itcrafters.brewstop.controller;

import eu.itcrafters.brewstop.controller.dto.ProductDto;
import eu.itcrafters.brewstop.controller.dto.ProductInfo;
import eu.itcrafters.brewstop.infrastructure.rest.error.ApiError;
import eu.itcrafters.brewstop.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

   @PostMapping("/product")
   @Operation(summary = "Adds product")
   @ApiResponses(value = {
           @ApiResponse(responseCode = "200", description = "ok"),
           @ApiResponse(responseCode = "404", description = "Product type not exist",
                   content = @Content(schema = @Schema(implementation = ApiError.class)))
   })
    public void addProduct(@RequestBody @Valid ProductDto productDto) {
       productService.addProduct(productDto);
   }


    @GetMapping("/products/{id}")
    @Operation(summary = "Finds product by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "ok"),
            @ApiResponse(responseCode = "404", description = "Product not exist",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public ProductDto findProduct(@PathVariable("id") Integer id) {
        return productService.findProduct(id);
    }


    @GetMapping("/products")
    @Operation(summary = "shows all products")
    public List<ProductInfo> findAll() {
        return productService.findAll();
    }


    @PutMapping("/product/{productId}")
    @Operation(summary = "Updates product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok"),
            @ApiResponse(responseCode = "400", description = "Invalid request body",
                    content = @Content(schema = @Schema(implementation = ApiError.class))),
            @ApiResponse(responseCode = "404", description = "Product not exist",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))

    })
public void updateProduct(@PathVariable Integer productId, @RequestBody @Valid ProductDto productDto) {
productService.updateProduct(productId, productDto);
    }

    @DeleteMapping("/product/{productId}")
    @Operation(summary = "Deletes product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok"),
            @ApiResponse(responseCode = "400", description = "Invalid request body",
                    content = @Content(schema = @Schema(implementation = ApiError.class))),
            @ApiResponse(responseCode = "404", description = "Id not found",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))

    })


    public void deleteProduct(@PathVariable Integer productId) {
       productService.deleteProduct(productId);
    }
}
