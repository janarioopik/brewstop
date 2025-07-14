package eu.itcrafters.brewstop.infrastructure.persistence.product;

import eu.itcrafters.brewstop.controller.dto.ProductDto;
import eu.itcrafters.brewstop.controller.dto.ProductInfo;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {

    @Mapping(source = "name", target = "name")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "category.name", target = "categoryName")

    ProductDto toProductDto(Product product);

    @InheritInverseConfiguration(name = "toProduct")
    @Mapping(source = "id", target = "id")
    @Mapping(source = "category.name", target = "categoryName")
    ProductInfo toProductInfo(Product product);


    List<ProductInfo> toProductInfos(List<Product> products);



    @Mapping(source = "name", target = "name")
    @Mapping(source = "price", target = "price")
    Product toProduct(ProductDto productDto);

@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @InheritConfiguration(name = "toProduct")
    Product updateProduct(ProductDto productDto, @MappingTarget Product product);

}

