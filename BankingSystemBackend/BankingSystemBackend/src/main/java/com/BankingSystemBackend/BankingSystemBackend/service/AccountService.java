package com.BankingSystemBackend.BankingSystemBackend.service;

import com.BankingSystemBackend.BankingSystemBackend.DAO.AccountDAO;
import com.BankingSystemBackend.BankingSystemBackend.model.Account;
import com.BankingSystemBackend.BankingSystemBackend.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    private AccountDAO accountDAO;
    public boolean createAccount(Customer customer){
        System.out.println("Service triggered.");
        Account account = new Account();
        account.setBalance(0);
        account.setCustomer(customer);
        try{
            accountDAO.save(account);
            return true;
        }catch (Exception e){
            return false;
        }

    }
}
