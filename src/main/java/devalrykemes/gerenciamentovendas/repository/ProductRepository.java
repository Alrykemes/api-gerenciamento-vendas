package devalrykemes.gerenciamentovendas.repository;

import devalrykemes.gerenciamentovendas.domain.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    /*
    @Query("SELECT p FROM Product p RIGHT JOIN Sale s ON p.id = s.id WHERE p.id = (:id)")
    List<Sale> findSalesById(@Param("product_id") Integer id);
     */
}