package eu.itcrafters.brewstop.infrastructure.persistence.priceChange;

import eu.itcrafters.brewstop.infrastructure.persistence.priceChange.dto.PriceChangeDto;
import org.mapstruct.Mapper;

import java.util.List;          // ⬅️ kasutame JDK List-i

@Mapper(componentModel = "spring")
public interface PriceChangeMapper {

    PriceChangeDto toDto(PriceChange pc);

    // ⬇️ paranda signatuur
    List<PriceChangeDto> toDtoList(List<PriceChange> changes);
}
