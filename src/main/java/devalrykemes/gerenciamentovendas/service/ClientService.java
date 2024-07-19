package devalrykemes.gerenciamentovendas.service;

import devalrykemes.gerenciamentovendas.domain.client.*;
import devalrykemes.gerenciamentovendas.domain.address.Address;
import devalrykemes.gerenciamentovendas.repository.AddressRepository;
import devalrykemes.gerenciamentovendas.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    AddressService addressService;

    public Client createClient(ClientRequestDto clientData) {
        Client newClient = new Client();
        newClient.setName(clientData.name());

        clientRepository.save(newClient);

        this.addressService.createAddress(clientData, newClient);

        return newClient;
    }

    public ClientDetailsDto updateClient(Integer id, ClientRequestDto data) {
        Optional<Client> client = clientRepository.findById(id);
        Optional<Address> address = addressService.findByClientId(id);

        if(client.isPresent() && address.isPresent()) {
            client.get().setName(data.name());
            address.get().setLogradouro(data.longradouro());
            address.get().setNumero(data.numero());
            address.get().setComplemento(data.complemento());
            address.get().setBairro(data.bairro());
            address.get().setCidade(data.cidade());
            address.get().setEstado(data.estado());
            address.get().setCep(data.cep());
            clientRepository.save(client.get());

            return new ClientDetailsDto(
                    client.get().getId(),
                client.get().getName(),
                address.get().getLogradouro(),
                address.get().getNumero(),
                address.get().getComplemento(),
                address.get().getBairro(),
                address.get().getCidade(),
                address.get().getEstado(),
                address.get().getCep()
            );
        }
        return null;
    }

    public ClientDetailsDto getClientDetails(Integer clientId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new IllegalArgumentException("Client not found"));

        Optional<Address> address = addressService.findByClientId(clientId);

        return new ClientDetailsDto(
                client.getId(),
                client.getName(),
                address.isPresent() ? address.get().getLogradouro() : "",
                address.isPresent() ? address.get().getNumero() : "",
                address.isPresent() ? address.get().getComplemento() : "",
                address.isPresent() ? address.get().getBairro() : "",
                address.isPresent() ? address.get().getCidade() : "",
                address.isPresent() ? address.get().getEstado() : "",
                address.isPresent() ? address.get().getCep() : ""
        );
    }

    public void deleteClient(Integer clientId) {
        this.addressRepository.delete(this.addressRepository.findByClientId(clientId)
                .orElseThrow(() -> new IllegalArgumentException("Client not found")));
        this.clientRepository.delete(this.clientRepository.findById(clientId)
                .orElseThrow(() -> new IllegalArgumentException("Client not found")));
    }

    public List<ClientResponseDto> searchClients(String name) {
        name = (name!= null) ? name : "";

        List<ClientAddressProjection> clientsList = this.clientRepository.findClientsByName(name);
        return clientsList.stream().map(client -> new ClientResponseDto(
                client.getId(),
                client.getName(),
                client.getLogradouro() != null ? client.getLogradouro() : "",
                client.getNumero() != null ? client.getNumero() : "",
                client.getComplemento() != null ? client.getComplemento() : "",
                client.getBairro() != null ? client.getBairro() : "",
                client.getCidade() != null ? client.getCidade() : "",
                client.getEstado() != null ? client.getEstado() : "",
                client.getCep() != null ? client.getCep() : "")
        ).toList();
    }


}
