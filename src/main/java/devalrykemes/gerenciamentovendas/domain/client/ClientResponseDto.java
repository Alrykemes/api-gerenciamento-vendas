package devalrykemes.gerenciamentovendas.domain.client;

public record ClientResponseDto(Integer id, String name, String logradouro, String numero, String complemento, String bairro, String cidade, String estado, String cep) {

}
