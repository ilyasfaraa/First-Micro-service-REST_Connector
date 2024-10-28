package com.ilyas.first_ms.Web;

import com.ilyas.first_ms.Dto.BankAccountRequestDTO;
import com.ilyas.first_ms.Dto.BankAccountResponseDTO;
import com.ilyas.first_ms.Entity.BankAccount;
import com.ilyas.first_ms.Mapper.AccountMapper;
import com.ilyas.first_ms.Repository.BankAccountRepo;
import com.ilyas.first_ms.Service.AccountServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AccountRestController {

    private final BankAccountRepo bankAccountRepo;
    private final AccountServiceImpl accountService;
    private final AccountMapper accountMapper;

    @GetMapping("/bankAccounts")
    public List<BankAccount> getAllBankAccounts() {
        return bankAccountRepo.findAll();
    }

    @GetMapping("/bankAccounts/{id}")
    public BankAccount bankAccounts(@PathVariable("id") String id) {
        return bankAccountRepo.findById(id).orElseThrow(() -> new RuntimeException("Bank Account not found"));
    }

    @PostMapping("/bankAccounts")
    public BankAccountResponseDTO saveBankAccount(@RequestBody BankAccountRequestDTO requestDTO) {
        return accountService.addAccount(requestDTO);
    }

    @PutMapping("/bankAccounts/{id}")
    public BankAccount updateBankAccount(@PathVariable("id") String id, @RequestBody BankAccount bankAccount) {
        BankAccount bankAccount1 = bankAccountRepo.findById(id).orElseThrow(() -> new RuntimeException("Bank Account not found"));
        if (bankAccount.getBalance() != null) bankAccount1.setBalance(bankAccount.getBalance());
        if (bankAccount.getCreatedAt() != null) bankAccount1.setCreatedAt(new Date());
        if (bankAccount.getType() != null) bankAccount1.setType(bankAccount.getType());
        if (bankAccount.getCurrency() != null) bankAccount1.setCurrency(bankAccount.getCurrency());
        return bankAccountRepo.save(bankAccount1);
    }

    @DeleteMapping("/bankAccounts/{id}")
    public void deleteBankAccounts(@PathVariable("id") String id) {
        bankAccountRepo.deleteById(id);
    }

}
