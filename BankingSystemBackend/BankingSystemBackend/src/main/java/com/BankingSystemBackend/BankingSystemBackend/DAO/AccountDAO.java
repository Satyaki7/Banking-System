package com.BankingSystemBackend.BankingSystemBackend.DAO;

import com.BankingSystemBackend.BankingSystemBackend.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDAO extends JpaRepository<Account,String> {
}
