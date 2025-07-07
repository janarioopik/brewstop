package eu.itcrafters.brewstop.service;

import eu.itcrafters.brewstop.controller.dto.ProductDto;
import eu.itcrafters.brewstop.controller.dto.ProductInfo;
import eu.itcrafters.brewstop.infrastructure.persistence.category.Category;
import eu.itcrafters.brewstop.infrastructure.persistence.category.CategoryRepository;
import eu.itcrafters.brewstop.infrastructure.persistence.product.Product;
import eu.itcrafters.brewstop.infrastructure.persistence.product.ProductMapper;
import eu.itcrafters.brewstop.infrastructure.persistence.product.ProductRepository;
import eu.itcrafters.brewstop.infrastructure.rest.error.Error;
import eu.itcrafters.brewstop.infrastructure.rest.exception.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final CategoryRepository categoryRepository;

    public void addProduct(ProductDto productDto) {
        Category category = categoryRepository.findCategoryNameBy(productDto.getCategoryName())
                .orElseThrow(() -> new DataNotFoundException(Error.NO_CATEGORY_EXISTS.getMessage()));
        Product product = productMapper.toProduct(productDto);
        product.setCategory(category);
        productRepository.save(product);

    }


    public List<ProductInfo> findAll() {
        List<Product> products = productRepository.findAll();

        return productMapper.toProductInfos(products);
    }


    public ProductDto findProduct(Integer id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Product is not in menu"));
        ProductDto productDto = productMapper.toProductDto(product);
        return productDto;
    }


}