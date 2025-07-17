package com.BankingSystemBackend.BankingSystemBackend.DAO;

import com.BankingSystemBackend.BankingSystemBackend.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDAO extends JpaRepository<Customer,String> {
    List<Customer> findByName(String name);
}
