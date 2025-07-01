package eu.itcrafters.brewstop.infrastructure.persistence.cafeorder;

import eu.itcrafters.brewstop.infrastructure.persistence.cafetable.CafeTable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "CAFE_ORDER")
public class CafeOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @NotNull
    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "CREATED_AT", nullable = false)
    private Instant createdAt;

    @Size(max = 10)
    @NotNull
    @ColumnDefault("'OPEN'")
    @Column(name = "STATUS", nullable = false, length = 10)
    private String status;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CAFE_TABLE_ID", nullable = false)
    private CafeTable cafeTable;

}