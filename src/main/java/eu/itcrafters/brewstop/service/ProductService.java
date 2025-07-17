package eu.itcrafters.brewstop.service;

import eu.itcrafters.brewstop.controller.dto.ProductDto;
import eu.itcrafters.brewstop.controller.dto.ProductInfo;
import eu.itcrafters.brewstop.infrastructure.persistence.category.Category;
import eu.itcrafters.brewstop.infrastructure.persistence.category.CategoryRepository;
import eu.itcrafters.brewstop.infrastructure.persistence.priceChange.PriceChange;
import eu.itcrafters.brewstop.infrastructure.persistence.priceChange.PriceChangeMapper;
import eu.itcrafters.brewstop.infrastructure.persistence.priceChange.PriceChangeRepository;
import eu.itcrafters.brewstop.infrastructure.persistence.priceChange.dto.PriceChangeDto;
import eu.itcrafters.brewstop.infrastructure.persistence.product.Product;
import eu.itcrafters.brewstop.infrastructure.persistence.product.ProductMapper;
import eu.itcrafters.brewstop.infrastructure.persistence.product.ProductRepository;
import eu.itcrafters.brewstop.infrastructure.rest.error.Error;
import eu.itcrafters.brewstop.infrastructure.rest.exception.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final CategoryRepository categoryRepository;
    private final PriceChangeRepository priceChangeRepository;
    private final PriceChangeMapper priceChangeMapper;

    public void addProduct(ProductDto productDto) {
        Category category = getValidProductname(productDto.getCategoryName());
        Product product = productMapper.toProduct(productDto);
        product.setCategory(category);
        productRepository.save(product);

    }


    public List<ProductInfo> findAll() {
        List<Product> products = productRepository.findAll();

        return productMapper.toProductInfos(products);
    }


    public ProductDto findProduct(Integer id) {
        Product product = getValidProduct(id);

        return productMapper.toProductDto(product);
    }


    public void updateProduct(Integer productId, ProductDto productDto) {
        Product product = getValidProduct(productId);
        Category productname = getValidProductname(productDto.getCategoryName());
        productMapper.updateProduct(productDto, product);
        product.setCategory(productname);
        productRepository.save(product);

    }

    private Category getValidProductname(String categoryName) {
        return categoryRepository.findCategoryNameBy(categoryName).orElseThrow(() -> new DataNotFoundException(Error.NO_CATEGORY_EXISTS.getMessage()));
    }

    private Product getValidProduct(Integer id) {
        return productRepository.findById(id).orElseThrow(() -> new DataNotFoundException(Error.NO_PRODUCT_EXISTS.getMessage()));
    }

    public void deleteProduct(Integer productId) {
        Product product = getValidProduct(productId);
        productRepository.delete(product);

    }
    public ProductDto changePrice(Integer productId, BigDecimal newPrice) {
        Product product = getValidProduct(productId);

        if (product.getPrice().compareTo(newPrice) == 0) {
            return productMapper.toProductDto(product);
        }
        PriceChange priceChange = new PriceChange();
        priceChange. setProduct(product);
        priceChange.setOldPrice(product.getPrice());
        priceChange.setNewPrice(newPrice);

        product.setPrice(newPrice);

        priceChangeRepository.save(priceChange);
        productRepository.save(product);
        return productMapper.toProductDto(product);
    }
    public List<PriceChangeDto> history(Integer productId) {

        getValidProduct(productId);


        return priceChangeMapper.toDtoList(
                (List<PriceChange>) priceChangeRepository
                        .findByProductIdOrderByChangedAtDesc(productId));


    }
}