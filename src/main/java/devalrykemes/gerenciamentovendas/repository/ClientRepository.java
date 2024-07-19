package devalrykemes.gerenciamentovendas.repository;

import devalrykemes.gerenciamentovendas.domain.client.Client;
import devalrykemes.gerenciamentovendas.domain.client.ClientAddressProjection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends CrudRepository<Client, Integer> {
    @Query("SELECT c.id AS id, c.name AS name, a.logradouro AS longradouro, a.numero AS numero," +
            "a.complemento AS complemento, a.bairro AS bairro, a.cidade AS cidade, a.estado AS estado," +
            "a.cep AS cep FROM Client c INNER JOIN Address a ON a.id = c.id " +
            "WHERE (:name = '' OR c.name LIKE %:name%)")
    public List<ClientAddressProjection> findClientsByName(@Param("name")String name);
}