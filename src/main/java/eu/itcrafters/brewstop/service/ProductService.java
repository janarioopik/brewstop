package eu.itcrafters.brewstop.service;

import eu.itcrafters.brewstop.controller.dto.ProductDto;
import eu.itcrafters.brewstop.controller.dto.ProductInfo;
import eu.itcrafters.brewstop.infrastructure.persistence.Product;
import eu.itcrafters.brewstop.infrastructure.rest.exception.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;


    public List<ProductInfo> findAll() {
        List<Product> products = productRepository.findAll();

        return productMapper.toProductInfos(products);
    }


    public ProductDto findProduct(Integer id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Product is not in menu"));
       ProductDto productDto = productMapper.toProductDto(product);
       return productDto;
    }
}