package sid.org.bankaccountservice.mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import sid.org.bankaccountservice.dto.BankAccountResponseDTO;
import sid.org.bankaccountservice.entities.BankAccount;
@Component
public class AccountMapper {
    public BankAccountResponseDTO fromBankAccount(BankAccount bankAccount){
        BankAccountResponseDTO bankAccountResponseDTO=new BankAccountResponseDTO();
        BeanUtils.copyProperties(bankAccount,bankAccountResponseDTO);
        return bankAccountResponseDTO;
    }
}
