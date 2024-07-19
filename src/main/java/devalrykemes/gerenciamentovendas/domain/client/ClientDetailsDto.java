package devalrykemes.gerenciamentovendas.domain.client;

public record ClientDetailsDto(
        Integer id,
        String name,
        String logradouro,
        String numero,
        String complemento,
        String bairro,
        String cidade,
        String estado,
        String cep) {


}
