package devalrykemes.gerenciamentovendas.repository;

import devalrykemes.gerenciamentovendas.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Integer> {

}