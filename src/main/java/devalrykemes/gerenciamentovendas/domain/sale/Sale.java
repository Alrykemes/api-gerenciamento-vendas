package devalrykemes.gerenciamentovendas.domain.sale;

import devalrykemes.gerenciamentovendas.domain.client.Client;
import devalrykemes.gerenciamentovendas.domain.product.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "sales")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="sale_id",unique = true, insertable = false, updatable = false, nullable = false)
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;
    @Column(nullable = false)
    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "sales",
            joinColumns = @JoinColumn(name = "sale_id"),
            inverseJoinColumns = @JoinColumn(name = "products_id"))
    private List<Product> products;
    @Column(nullable = false)
    private Date date;
    @Column(nullable = false)
    private BigDecimal price;

    public Sale(SaleRequestDto saleData) {
        this.client = saleData.client();
        this.products = saleData.products();
        this.date = saleData.date();
        this.price = saleData.price();
    }

}
