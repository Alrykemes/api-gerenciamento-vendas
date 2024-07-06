package devalrykemes.gerenciamentovendas.controller;

import devalrykemes.gerenciamentovendas.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;

    @GetMapping

}
