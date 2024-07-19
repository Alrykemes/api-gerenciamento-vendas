package devalrykemes.gerenciamentovendas.domain.address;

public record AddressRequestDto(String longradouro, String numero, String complemento, String bairro, String cidade, String estado, String cep) {
}
