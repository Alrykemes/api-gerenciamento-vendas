package devalrykemes.gerenciamentovendas.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "Products", schema = "Sales-Manager")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="product_id",unique = true)
    private Integer id;
    @Column(length = 30, nullable = false)
    private String name;
    @Column(length = 150, nullable = false)
    private String description;
    @Column(nullable = false)
    private BigDecimal price;


}
