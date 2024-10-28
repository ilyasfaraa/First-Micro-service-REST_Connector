package com.ilyas.first_ms.Entity;

import com.ilyas.first_ms.Enum.AccountType;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class BankAccount {
    @Id
    private String id;
    private Date createdAt;
    private Double balance;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    @ManyToOne
    private Customer customer;
}
