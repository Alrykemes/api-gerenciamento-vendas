package devalrykemes.gerenciamentovendas.repository;

import devalrykemes.gerenciamentovendas.domain.address.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    Optional<Address> findByClientId(Integer clientId);
}
