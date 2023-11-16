package sid.org.bankaccountservice.web;

import org.springframework.web.bind.annotation.*;
import sid.org.bankaccountservice.dto.BankAccountRequestDTO;
import sid.org.bankaccountservice.dto.BankAccountResponseDTO;
import sid.org.bankaccountservice.entities.BankAccount;
import sid.org.bankaccountservice.mappers.AccountMapper;
import sid.org.bankaccountservice.repositories.BankAccountRepository;
import sid.org.bankaccountservice.service.AccountService;

import java.util.List;

@RequestMapping("/api")
@RestController
public class AccountRestController {
    private BankAccountRepository bankAccountRepository;
    private AccountService accountService;
    private AccountMapper accountMapper;
    public AccountRestController(BankAccountRepository bankAccoutRepository, AccountService accountService, AccountMapper accountMapper) {
        this.bankAccountRepository = bankAccoutRepository;
        this.accountService = accountService;
        this.accountMapper = accountMapper;
    }
    @GetMapping("/bankAccounts")
    public List<BankAccount> bankAccounts(){
        return bankAccountRepository.findAll();
    }
    @GetMapping("/bankAccount/{id}")
    public BankAccount bankAccount(@PathVariable String id){
        return bankAccountRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Account %s not found",id)));
    }
    @PostMapping("/bankAccounts")
    public BankAccountResponseDTO save(@RequestBody BankAccountRequestDTO requestDTO)
    {
        return accountService.addAccount(requestDTO);
    }
    @PutMapping("/bankAccount/{id}")
    public BankAccount update(@PathVariable String id,@RequestBody BankAccount bankAccount){
       BankAccount account= bankAccountRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("Account %s not found",id)));
        if (bankAccount.getBalance()!=null) account.setBalance(bankAccount.getBalance());
        if (bankAccount.getCreateAt()!=null) account.setCreateAt(bankAccount.getCreateAt());
        if (bankAccount.getCurrency()!=null) account.setCurrency(bankAccount.getCurrency());
        if (bankAccount.getType()!=null) account.setType(bankAccount.getType());
        return bankAccountRepository.save(account);
    }

    @DeleteMapping("/bankAccounts/{id}")
    public void deleteAcccountById(@PathVariable String id) {
        bankAccountRepository.deleteById(id);
    }



}
