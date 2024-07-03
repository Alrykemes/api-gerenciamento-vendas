package devalrykemes.gerenciamentovendas.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Sale", schema = "Sales-Manager")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="sale_id",unique = true)
    private Integer id;
    @Column(nullable = false)
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private List<Product> product = new ArrayList<Product>();
    @Column(nullable = false)
    private int quantity;
    @Column(nullable = false)
    private BigDecimal price;
    @Column(nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;


}
