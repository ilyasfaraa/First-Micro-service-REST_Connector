package com.ilyas.first_ms.Web;

import com.ilyas.first_ms.Dto.BankAccountRequestDTO;
import com.ilyas.first_ms.Dto.BankAccountResponseDTO;
import com.ilyas.first_ms.Entity.BankAccount;
import com.ilyas.first_ms.Entity.Customer;
import com.ilyas.first_ms.Repository.BankAccountRepo;
import com.ilyas.first_ms.Repository.CustomerRepo;
import com.ilyas.first_ms.Service.AccountServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BankAccountGraphQLController {

    private final BankAccountRepo bankAccountRepo;
    private final AccountServiceImpl accountService;
    private final CustomerRepo customerRepo;

    @QueryMapping
    public List<BankAccount> accountsList() {
        return bankAccountRepo.findAll();
    }

    @QueryMapping
    public BankAccount bankAccountById(@Argument String id) {
        return bankAccountRepo.findById(id).orElseThrow(() -> new RuntimeException(String.format("Bank account %s not found", id)));
    }

    @MutationMapping
    public BankAccountResponseDTO addAccount(@Argument BankAccountRequestDTO bankAccount) {
        return accountService.addAccount(bankAccount);
    }

    @MutationMapping
    public BankAccountResponseDTO updateAccount(@Argument String id, @Argument BankAccountRequestDTO bankAccount) {
        return accountService.updateAccount(id, bankAccount);
    }

    @MutationMapping
    public boolean deleteAccount(@Argument String id) {
        try {
            bankAccountRepo.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @QueryMapping
    public List<Customer> customers() {
        return customerRepo.findAll();
    }

}

//record BankAccountDTO(Double balance, String type, String currency) {}