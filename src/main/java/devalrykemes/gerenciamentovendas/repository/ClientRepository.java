package devalrykemes.gerenciamentovendas.repository;

import devalrykemes.gerenciamentovendas.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, Integer> {

}
