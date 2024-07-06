package devalrykemes.gerenciamentovendas.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "sales")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="sale_id",unique = true, insertable = false, updatable = false, nullable = false)
    private Integer id;
    @Column(nullable = false)
    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "sale_product",
            joinColumns = @JoinColumn(name = "sale_id"),
            inverseJoinColumns = @JoinColumn(name = "products_id"))
    private List<Product> products;
    @Column(nullable = false)
    private int quantity;
    @Column(nullable = false)
    private BigDecimal price;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;


}
