package devalrykemes.gerenciamentovendas.domain.address;

import devalrykemes.gerenciamentovendas.domain.client.Client;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "Address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id", unique = true, insertable = false, updatable = false)
    private Integer id;
    @Column(nullable = false)
    private String logradouro;
    @Column(nullable = false)
    private String numero;
    @Column(nullable = false)
    private String complemento;
    @Column(nullable = false)
    private String bairro;
    @Column(nullable = false)
    private String cidade;
    @Column(nullable = false)
    private String estado;
    @Column(nullable = false)
    private String cep;
    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Address(AddressRequestDto addressData) {
        this.logradouro = addressData.longradouro();
        this.numero = addressData.numero();
        this.complemento = addressData.complemento();
        this.bairro = addressData.bairro();
        this.cidade = addressData.cidade();
        this.estado = addressData.estado();
        this.cep = addressData.cep();
    }
}

