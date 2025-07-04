package eu.itcrafters.brewstop.service;

import eu.itcrafters.brewstop.controller.ProductDto;
import eu.itcrafters.brewstop.infrastructure.persistence.Product;
import org.mapstruct.Mapper;
import org.springframework.web.bind.annotation.Mapping;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(source = "category.id", target = "categoryId")
    ProductDto toDto(Optional<Product> entity);

    @Mapping(source = "categoryId", target = "category.id")
    Product toEntity(ProductDto dto);
}
