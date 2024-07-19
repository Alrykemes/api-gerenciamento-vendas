package devalrykemes.gerenciamentovendas.projections;

public interface ClientAddressProjection {
    Integer getId();
    String getName();
    String getLongradouro();;
    String getNumero();
    String getComplemento();
    Boolean getBairro();
    String getCidade();
    String getEstado();
    String getCep();
}
