package devalrykemes.gerenciamentovendas.domain.client;

public record ClientRequestDto(String name, String longradouro, String numero, String complemento, String bairro, String cidade, String estado, String cep) {
}
