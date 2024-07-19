package devalrykemes.gerenciamentovendas.domain.address;

public record AddressResponseDto(Integer id, String longradouro,
                                 String numero, String complemento,
                                 String bairro, String cidade,
                                 String estado, String cep) {
    public AddressResponseDto(Address address) {
        this(address.getId(), address.getLogradouro(),
                address.getNumero(), address.getComplemento(),
                address.getBairro(), address.getCidade(),
                address.getEstado(), address.getCep());
    }
}
