package spingbootdatajpa.spingdatajpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "product",
schema = "ecommerce",
uniqueConstraints = {
        @UniqueConstraint(
                name = "sku_unique",
                columnNames = "stock_keeping_unit"
        ),
        @UniqueConstraint(
                name = "name_unique",
                columnNames = "name"
        )
})
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "product_generator")
    @SequenceGenerator(name = "product_generator",
    sequenceName = "product_sequence_name",
    allocationSize = 1)
    private Long id;
    @Column(name = "stock_keeping_unit")
    private String sku;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)

    private String description;
    @Column(nullable = false)

    private BigDecimal price;
    @Column(nullable = false)

    private Boolean active;
    @Column(nullable = false)

    private String imageUrl;
    @CreationTimestamp
    private LocalDateTime dateTime;
    @UpdateTimestamp
    private LocalDateTime lastUpdated;



}
