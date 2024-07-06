package devalrykemes.gerenciamentovendas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "Address")
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id", unique = true, insertable = false, updatable = false)
    private Integer id;
    @Column(nullable = false)
    private String cidade;
    @Column(nullable = false)
    private String estado;
    @Column(nullable = false)
    private String logradouro;
    @Column(nullable = false)
    private String bairro;
    @Column(nullable = false)
    private String numero;
    @Column(nullable = false)
    private String complemento;
    @Column(nullable = false)
    private String cep;

}

