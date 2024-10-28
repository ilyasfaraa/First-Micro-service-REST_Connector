package com.ilyas.first_ms.Service;

import com.ilyas.first_ms.Dto.BankAccountRequestDTO;
import com.ilyas.first_ms.Dto.BankAccountResponseDTO;
import com.ilyas.first_ms.Entity.BankAccount;
import com.ilyas.first_ms.Mapper.AccountMapper;
import com.ilyas.first_ms.Repository.BankAccountRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final BankAccountRepo bankAccountRepo;
    private final AccountMapper accountMapper;

    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO) {
        BankAccount bankAccount = BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .createdAt(new Date())
                .balance(bankAccountDTO.getBalance())
                .type(bankAccountDTO.getType())
                .currency(bankAccountDTO.getCurrency())
                .build();
        BankAccount saveBankAccount = bankAccountRepo.save(bankAccount);
        /*BankAccountResponseDTO responseDTO = BankAccountResponseDTO.builder()
                .id(saveBankAccount.getId())
                .createdAt(saveBankAccount.getCreatedAt())
                .balance(saveBankAccount.getBalance())
                .type(saveBankAccount.getType())
                .currency(saveBankAccount.getCurrency())
                .build();*/

        BankAccountResponseDTO responseDTO = accountMapper.fromBankAccount(saveBankAccount);
        return responseDTO;
    }

    @Override
    public BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccountDTO) {
        BankAccount bankAccount = BankAccount.builder()
                .id(id)
                .createdAt(new Date())
                .balance(bankAccountDTO.getBalance())
                .type(bankAccountDTO.getType())
                .currency(bankAccountDTO.getCurrency())
                .build();
        BankAccount saveBankAccount = bankAccountRepo.save(bankAccount);
        /*BankAccountResponseDTO responseDTO = BankAccountResponseDTO.builder()
                .id(saveBankAccount.getId())
                .createdAt(saveBankAccount.getCreatedAt())
                .balance(saveBankAccount.getBalance())
                .type(saveBankAccount.getType())
                .currency(saveBankAccount.getCurrency())
                .build();*/

        BankAccountResponseDTO responseDTO = accountMapper.fromBankAccount(saveBankAccount);
        return responseDTO;
    }
}
