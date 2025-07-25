package com.BankingSystemBackend.BankingSystemBackend.service;

import com.BankingSystemBackend.BankingSystemBackend.DAO.AccountDAO;
import com.BankingSystemBackend.BankingSystemBackend.model.Account;
import com.BankingSystemBackend.BankingSystemBackend.model.Customer;
import com.BankingSystemBackend.BankingSystemBackend.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

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

    public String updateAccountBalance(Map<String,String> body){
        Account account = accountDAO.getReferenceById(body.get("accountId"));
        String transactionType = body.get("type");
        String amount = body.get("amount");
        if (transactionType.equals("Add")){
            long lastAmount = account.getBalance();
            account.setBalance(lastAmount + Long.parseLong(amount));
            account.setTransactions("Pocket",Long.parseLong(amount),"credited");
            accountDAO.save(account);
            return "Transaction successful";
        }else if(transactionType.equals("Deduct")) {
            long lastAmount = account.getBalance();
            if (Long.parseLong(amount) > lastAmount) {
                return "Transaction declined due to low funds.";
            } else {
                account.setBalance(lastAmount - Long.parseLong(amount));
                account.setTransactions("Pocket",Long.parseLong(amount),"debited",account.getAccountId());
                accountDAO.save(account);
                return "Transaction successful";
            }
        }else return "Unexpected error";
    }

    public Set<Transaction> getTransactions(String accountID) {
        Account ac = accountDAO.getReferenceById(accountID);
        return ac.getTransactions();
    }
}
