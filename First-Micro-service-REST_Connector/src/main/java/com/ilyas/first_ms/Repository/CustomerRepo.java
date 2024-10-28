package com.ilyas.first_ms.Repository;

import com.ilyas.first_ms.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,Long> {

}
