package devalrykemes.gerenciamentovendas.controller;

import devalrykemes.gerenciamentovendas.domain.client.ClientDetailsDto;
import devalrykemes.gerenciamentovendas.domain.client.ClientRequestDto;
import devalrykemes.gerenciamentovendas.domain.client.ClientResponseDto;
import devalrykemes.gerenciamentovendas.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/clientes")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping
    public ResponseEntity<ClientRequestDto> saveClient(@RequestBody ClientRequestDto clientData) {
        this.clientService.createClient(clientData);
        return ResponseEntity.ok(clientData);
    }

    @PutMapping("/{clientId}")
    public ResponseEntity<ClientDetailsDto> updateClient(@PathVariable Integer clientId, @RequestBody ClientRequestDto clientData) {
        ClientDetailsDto clientUpdated = clientService.updateClient(clientId, clientData);
        if(Objects.nonNull(clientUpdated)) {
            return ResponseEntity.ok(clientUpdated);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<ClientDetailsDto> getClient(@PathVariable Integer clientId) {
        ClientDetailsDto clientDetails = this.clientService.getClientDetails(clientId);
        return ResponseEntity.ok(clientDetails);
    }

    @GetMapping("/search")
    public ResponseEntity<List<ClientResponseDto>> getSearchClients(@RequestParam String name) {
        List<ClientResponseDto> clients = this.clientService.searchClients(name);
        return ResponseEntity.ok(clients);
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity deleteClient(@PathVariable Integer clientId) {
        clientService.deleteClient(clientId);
        return ResponseEntity.ok("Cliente com o ID: " + clientId + "deletado.");
    }

}
