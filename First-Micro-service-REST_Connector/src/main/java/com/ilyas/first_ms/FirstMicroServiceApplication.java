package com.ilyas.first_ms;

import com.ilyas.first_ms.Entity.BankAccount;
import com.ilyas.first_ms.Entity.Customer;
import com.ilyas.first_ms.Enum.AccountType;
import com.ilyas.first_ms.Repository.BankAccountRepo;
import com.ilyas.first_ms.Repository.CustomerRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class FirstMicroServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstMicroServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner run(BankAccountRepo bankAccountRepo, CustomerRepo customerRepo) {
        return args -> {
            Stream.of("Mohamed", "Hamza", "Ayoub").forEach(c -> {
                Customer customer = Customer.builder()
                        .name(c)
                        .build();
                customerRepo.save(customer);
            });
            customerRepo.findAll().forEach(customer -> {
                for (int i = 0; i < 10; i++) {
                    BankAccount bankAccount = BankAccount.builder()
                            .id(UUID.randomUUID().toString())
                            .type(Math.random() > 0.5 ? AccountType.CURRENT_ACCOUNT : AccountType.SAVING_ACCOUNT)
                            .balance(Math.random() * 1700)
                            .createdAt(new Date())
                            .currency("MAD")
                            .customer(customer)
                            .build();
                    bankAccountRepo.save(bankAccount);
                }
            });
        };
    }

}
