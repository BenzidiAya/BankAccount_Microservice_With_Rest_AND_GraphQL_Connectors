package sid.org.bankaccountservice.entities;

import org.springframework.data.rest.core.config.Projection;
import sid.org.bankaccountservice.enums.AccountType;

@Projection(types= BankAccount.class, name="p1")
public interface AccountProjection {
    public String getId();
    public AccountType getType();
}
