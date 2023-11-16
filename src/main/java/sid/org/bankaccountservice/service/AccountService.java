package sid.org.bankaccountservice.service;

import sid.org.bankaccountservice.dto.BankAccountResponseDTO;
import sid.org.bankaccountservice.dto.BankAccountRequestDTO;

public interface AccountService {
    BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);
    BankAccountResponseDTO update(String id ,BankAccountRequestDTO bankAccountDTO);
}
