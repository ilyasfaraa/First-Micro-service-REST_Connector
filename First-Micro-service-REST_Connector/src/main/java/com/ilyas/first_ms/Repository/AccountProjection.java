package com.ilyas.first_ms.Repository;

import com.ilyas.first_ms.Entity.BankAccount;
import com.ilyas.first_ms.Enum.AccountType;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = BankAccount.class, name = "p1")
public interface AccountProjection {
    public String getId();
    public AccountType getType();
    public Double getBalance();
}
