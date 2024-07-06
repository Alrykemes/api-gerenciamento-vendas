package devalrykemes.gerenciamentovendas.repository;

import devalrykemes.gerenciamentovendas.model.Client;
import devalrykemes.gerenciamentovendas.model.Product;
import devalrykemes.gerenciamentovendas.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("SELECT p FROM Product p RIGHT JOIN Sale s ON p.id = s.id WHERE p.id = (:id)")
    List<Sale> findSalesById(@Param("product_id") Integer id);
}