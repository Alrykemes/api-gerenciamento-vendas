package devalrykemes.gerenciamentovendas.model;
import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "Clients", schema = "Sales-Manager")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="client_id",unique = true)
    private Integer id;
    @Column(length = 30, nullable = false)
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", nullable = false)
    private AddressEntity adress;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "sale_id", nullable = false)
    @Column(name = "purchases_id")
    private List<Sale> purchases = new ArrayList<>();


}