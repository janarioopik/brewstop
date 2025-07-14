package eu.itcrafters.brewstop.infrastructure.persistence.priceChange.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@Data
public class PriceChangeDto {
    private BigDecimal oldPrice;
    private BigDecimal newPrice;
    private Instant changedAt;
}

