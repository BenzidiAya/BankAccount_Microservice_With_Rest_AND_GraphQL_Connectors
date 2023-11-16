package sid.org.bankaccountservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sid.org.bankaccountservice.dto.BankAccountRequestDTO;
import sid.org.bankaccountservice.dto.BankAccountResponseDTO;
import sid.org.bankaccountservice.entities.BankAccount;
import sid.org.bankaccountservice.mappers.AccountMapper;
import sid.org.bankaccountservice.repositories.BankAccountRepository;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountMapper accountMapper;
    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO) {
        BankAccount bankAccount=BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .type(bankAccountDTO.getType())
                .balance(bankAccountDTO.getBalance())
                .createAt(new Date())
                .currency(bankAccountDTO.getCurrency())
                .build();
        BankAccount saveBankAccount=bankAccountRepository.save(bankAccount);
        BankAccountResponseDTO bankAccountResponseDTO = accountMapper.fromBankAccount(saveBankAccount);
        return null;
    }

    @Override
    public BankAccountResponseDTO update(String id, BankAccountRequestDTO bankAccountDTO) {
        BankAccount account = BankAccount.builder()
                .id(id)
                .createAt(new Date())
                .balance(bankAccountDTO.getBalance())
                .currency(bankAccountDTO.getCurrency())
                .type(bankAccountDTO.getType())
                .build();
        BankAccount bankAccount = bankAccountRepository.save(account);
        BankAccountResponseDTO responseDTO = accountMapper.fromBankAccount(bankAccount);
        return responseDTO;
    }

}
