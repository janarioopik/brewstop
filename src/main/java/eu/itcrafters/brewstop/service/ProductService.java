package eu.itcrafters.brewstop.service;

import eu.itcrafters.brewstop.controller.dto.ProductDto;
import eu.itcrafters.brewstop.infrastructure.persistence.Product;
import eu.itcrafters.brewstop.infrastructure.rest.exception.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;




 //   public List<ProductDto> getAll() {
 //       return productRepository.findAll().stream().map(productMapper::toDto).toList();
  //  }

    public ProductDto findProduct(Integer id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Product not found"));
       ProductDto productDto = productMapper.toProductDto(product);
       return productDto;
    }
}