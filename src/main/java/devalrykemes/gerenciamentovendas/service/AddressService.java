package devalrykemes.gerenciamentovendas.service;

import devalrykemes.gerenciamentovendas.domain.client.ClientRequestDto;
import devalrykemes.gerenciamentovendas.domain.address.Address;
import devalrykemes.gerenciamentovendas.domain.client.Client;
import devalrykemes.gerenciamentovendas.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public Address createAddress(ClientRequestDto data, Client client) {
        Address address = new Address();
        address.setLogradouro(data.longradouro());
        address.setNumero(data.numero());
        address.setComplemento(data.complemento());
        address.setBairro(data.bairro());
        address.setCidade(data.cidade());
        address.setEstado(data.estado());
        address.setCep(data.cep());
        address.setClient(client);

        return addressRepository.save(address);
    }

    public Optional<Address> findByClientId(Integer clientId) {
        return addressRepository.findByClientId(clientId);
    }
}