package eu.itcrafters.brewstop.infrastructure.persistence.product;

import eu.itcrafters.brewstop.infrastructure.persistence.category.Category;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "PRODUCT")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Size(max = 100)
    @NotNull
    @Column(name = "NAME", nullable = false, length = 100)
    private String name;

    @NotNull
    @Column(name = "PRICE", nullable = false, precision = 7, scale = 2)
    private BigDecimal price;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "CATEGORY_ID", nullable = false)
    private Category category;


}