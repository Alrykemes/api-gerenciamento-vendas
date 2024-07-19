package devalrykemes.gerenciamentovendas.domain.client;
import jakarta.persistence.*;
import lombok.*;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="client_id",unique = true, insertable = false, updatable = false)
    private Integer id;
    @Column(length = 30, nullable = false)
    private String name;

    public Client(ClientRequestDto clientData) {
        this.name = clientData.name();
    }
}