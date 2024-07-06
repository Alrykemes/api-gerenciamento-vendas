package devalrykemes.gerenciamentovendas.repository;

import devalrykemes.gerenciamentovendas.model.Client;
import devalrykemes.gerenciamentovendas.model.Sale;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends CrudRepository<Client, Integer> {
    @Query("SELECT e FROM Client e WHERE e.name= (:name)")
    List<Client> findByName(@Param("name") String name);

    @Query("SELECT e FROM Client e FULL OUTER JOIN AddressEntity a ON e.id = a.id WHERE e.name = (:name)")
    public Client findAddressByName(@Param("name") String name);

    @Query("SELECT e FROM Client e FULL OUTER JOIN Sale s ON e.id = s.id WHERE e.name = (:name)")
    List<Sale> findPurchasesByName(@Param("name") String name);
}
