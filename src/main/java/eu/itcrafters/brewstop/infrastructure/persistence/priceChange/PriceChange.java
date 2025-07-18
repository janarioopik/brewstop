package eu.itcrafters.brewstop.infrastructure.persistence.priceChange;

import eu.itcrafters.brewstop.infrastructure.persistence.product.Product;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "PRICE_CHANGE")
public class PriceChange {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    @Column(name = "OLD_PRICE", nullable = false, precision = 7, scale = 2)
    private BigDecimal oldPrice;

    @Column(name = "NEW_PRICE", nullable = false, precision = 7, scale = 2)
    private BigDecimal newPrice;


    @CreationTimestamp
    @Column(name = "CHANGED_AT", nullable = false, updatable = false)
    private Instant changedAt;
}
