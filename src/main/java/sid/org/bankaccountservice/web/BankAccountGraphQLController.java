package sid.org.bankaccountservice.web;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import sid.org.bankaccountservice.dto.BankAccountRequestDTO;
import sid.org.bankaccountservice.dto.BankAccountResponseDTO;
import sid.org.bankaccountservice.entities.BankAccount;
import sid.org.bankaccountservice.entities.Customer;
import sid.org.bankaccountservice.repositories.BankAccountRepository;
import sid.org.bankaccountservice.repositories.CustomerRepository;
import sid.org.bankaccountservice.service.AccountService;
import sid.org.bankaccountservice.service.AccountServiceImpl;

import java.util.List;

@Controller
@AllArgsConstructor
public class BankAccountGraphQLController {
    private BankAccountRepository bankAccountRepository;
    private AccountServiceImpl accountService;
    private CustomerRepository customerRepository;
    @QueryMapping
    public List<BankAccount> accountsList(){

        return bankAccountRepository.findAll();
    }
    @QueryMapping
    public BankAccount accountById(@Argument String id) {
        return bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("account %s not found", id)));
    }

    @MutationMapping
    public BankAccountResponseDTO addAccount(@Argument BankAccountRequestDTO bankAccount) {
        return accountService.addAccount(bankAccount);
    }

    @MutationMapping
    public BankAccountResponseDTO updateAccount(@Argument String id, @Argument BankAccountRequestDTO bankAccount) {
        return accountService.update(id, bankAccount);
    }

    @MutationMapping
    public boolean deleteAccount(@Argument String id) {
        bankAccountRepository.deleteById(id);
        return true;
    }

    @QueryMapping
    public List<Customer> customersList() {
        return customerRepository.findAll();
    }
}
