package devalrykemes.gerenciamentovendas.domain.product;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import devalrykemes.gerenciamentovendas.domain.sale.Sale;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.List;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "product")
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
    @Column(nullable = false)
    @ManyToMany(mappedBy = "products")
    @JsonIgnoreProperties("products")
    private List<Sale> sales;

    public Product(ProductRequestDto productData) {
        this.name = productData.name();
        this.description = productData.description();
        this.price = productData.price();
    }

}
