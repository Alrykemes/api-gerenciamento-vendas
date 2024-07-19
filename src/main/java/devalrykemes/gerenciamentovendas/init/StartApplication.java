package devalrykemes.gerenciamentovendas.init;

import devalrykemes.gerenciamentovendas.repository.AddressRepository;
import devalrykemes.gerenciamentovendas.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartApplication implements CommandLineRunner {
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    AddressRepository addressRepository;
    @Override
    public void run(String... args) throws Exception {

    }
}
