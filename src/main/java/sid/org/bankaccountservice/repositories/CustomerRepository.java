package sid.org.bankaccountservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sid.org.bankaccountservice.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
