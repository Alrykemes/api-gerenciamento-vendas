package devalrykemes.gerenciamentovendas.domain.client;

public interface ClientAddressProjection {
    Integer getId();
    String getName();
    String getLogradouro();
    String getNumero();
    String getComplemento();
    String getBairro();
    String getCidade();
    String getEstado();
    String getCep();

}
