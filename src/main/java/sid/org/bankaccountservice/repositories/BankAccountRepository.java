package sid.org.bankaccountservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import sid.org.bankaccountservice.entities.BankAccount;
import sid.org.bankaccountservice.enums.AccountType;

import java.util.List;

@RepositoryRestResource
public interface BankAccountRepository extends JpaRepository<BankAccount,String> {

    @RestResource(path="/ByType")
    List<BankAccount> findByType(@Param("t") AccountType type);
}


