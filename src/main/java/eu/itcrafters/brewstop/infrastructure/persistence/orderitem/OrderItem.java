package eu.itcrafters.brewstop.infrastructure.persistence.orderitem;

import eu.itcrafters.brewstop.infrastructure.persistence.cafeorder.CafeOrder;
import eu.itcrafters.brewstop.infrastructure.persistence.dish.Dish;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ORDER_ITEM")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "QTY", nullable = false)
    private Integer qty;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CAFE_ORDER_ID", nullable = false)
    private CafeOrder cafeOrder;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DISH_ID", nullable = false)
    private Dish dish;

}