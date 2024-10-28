package com.ilyas.first_ms.Dto;

import com.ilyas.first_ms.Enum.AccountType;
import lombok.*;

@AllArgsConstructor @NoArgsConstructor @Builder
@Data
public class BankAccountRequestDTO {

    private Double balance;
    private String currency;
    private AccountType type;

}
