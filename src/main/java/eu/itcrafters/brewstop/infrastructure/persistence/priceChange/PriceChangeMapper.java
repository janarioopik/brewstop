package eu.itcrafters.brewstop.infrastructure.persistence.priceChange;

import eu.itcrafters.brewstop.infrastructure.persistence.priceChange.dto.PriceChangeDto;
import org.hsqldb.lib.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceChangeMapper {
    PriceChangeDto toDto(PriceChange pc);
}