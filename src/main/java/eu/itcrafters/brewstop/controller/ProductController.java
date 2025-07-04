package eu.itcrafters.brewstop.controller;

import eu.itcrafters.brewstop.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping public List<ProductDto> all() {return productService.getAll();}
    @GetMapping("/{id}") public ProductDto findById(@PathVariable Integer id) {
        return productService.get(id);
    }
}
