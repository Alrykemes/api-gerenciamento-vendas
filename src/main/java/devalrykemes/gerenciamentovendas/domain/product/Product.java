package devalrykemes.gerenciamentovendas.domain.product;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="product_id",unique = true, insertable = false, updatable = false)
    private Integer id;
    @Column(length = 30, nullable = false)
    private String name;
    @Column(length = 150, nullable = false)
    private String description;
    @Column(nullable = false)
    private BigDecimal price;

    public Product(ProductRequestDto productData) {
        this.name = productData.name();
        this.description = productData.description();
        this.price = productData.price();
    }

}
