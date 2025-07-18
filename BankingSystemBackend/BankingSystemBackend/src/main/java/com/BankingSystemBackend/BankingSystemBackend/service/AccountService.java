package com.BankingSystemBackend.BankingSystemBackend.service;

import com.BankingSystemBackend.BankingSystemBackend.DAO.AccountDAO;
import com.BankingSystemBackend.BankingSystemBackend.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    private Account account;
    @Autowired
    private AccountDAO accountDAO;
    public Account createAccount(){
        account.setBalance(0);
        return account;
    }
}
