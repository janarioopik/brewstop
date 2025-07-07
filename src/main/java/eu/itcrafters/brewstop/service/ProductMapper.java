package eu.itcrafters.brewstop.service;

import eu.itcrafters.brewstop.controller.dto.ProductDto;
import eu.itcrafters.brewstop.controller.dto.ProductInfo;
import eu.itcrafters.brewstop.infrastructure.persistence.Product;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {

    @Mapping(source = "name", target = "name")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "category.name", target = "categoryName")

    ProductDto toProductDto(Product product);

    @InheritInverseConfiguration(name = "toProductDto")
    @Mapping(source = "id", target = "id")
    @Mapping(source = "category.name", target = "categoryName")
    ProductInfo toProductInfo(Product product);


    List<ProductInfo> toProductInfos(List<Product> products);
}

