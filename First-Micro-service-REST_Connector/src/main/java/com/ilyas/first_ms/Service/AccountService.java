package com.ilyas.first_ms.Service;

import com.ilyas.first_ms.Dto.BankAccountRequestDTO;
import com.ilyas.first_ms.Dto.BankAccountResponseDTO;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {
    BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);

    BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccountDTO);
}
