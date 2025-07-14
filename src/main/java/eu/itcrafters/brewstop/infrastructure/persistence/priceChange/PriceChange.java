package eu.itcrafters.brewstop.infrastructure.persistence.priceChange;

import eu.itcrafters.brewstop.infrastructure.persistence.product.Product;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "PRICE_CHANGE")
public class PriceChange {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PRODUCT_ID", nullable = false)
    private Product product;

    @NotNull
    @Column(name = "OLD_PRICE", nullable = false, precision = 7, scale = 2)
    private BigDecimal oldPrice;

    @NotNull
    @Column(name = "NEW_PRICE", nullable = false, precision = 7, scale = 2)
    private BigDecimal newPrice;

    @NotNull
    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "CHANGED_AT", nullable = false)
    private Instant changedAt;

}