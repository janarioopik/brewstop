package eu.itcrafters.brewstop.service;

import eu.itcrafters.brewstop.controller.ProductDto;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.beans.factory.config.YamlProcessor.MatchStatus.NOT_FOUND;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper


    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDto> getAll() {
        return productRepository.findAll().stream().map(productMapper::toDto). toList();
    }

    public ProductDto get(Integer id) {
        return productMapper.toDto(productRepository.findById(id))
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND));
    }
}
