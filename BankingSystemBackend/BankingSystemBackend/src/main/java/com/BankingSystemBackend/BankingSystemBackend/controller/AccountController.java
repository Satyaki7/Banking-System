package com.BankingSystemBackend.BankingSystemBackend.controller;

import com.BankingSystemBackend.BankingSystemBackend.model.Account;
import com.BankingSystemBackend.BankingSystemBackend.model.Customer;
import com.BankingSystemBackend.BankingSystemBackend.model.Transaction;
import com.BankingSystemBackend.BankingSystemBackend.service.AccountService;
import com.BankingSystemBackend.BankingSystemBackend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;
    @Autowired
    private CustomerService customerService;

    @GetMapping("/check")
    public String helloWorld(){
        System.out.println("working");
        return "hello world";
    }
    @PostMapping("/createAccount")
    public boolean createAccount(@RequestBody Map<String, String> body){
        String customerId = body.get("customerId");
        Optional<Customer> customer = customerService.getCustomer(customerId);
        return accountService.createAccount(customer.orElse(null));
    }

    @PostMapping("/updateBalance")
    public String updateBalance(@RequestBody Map<String,String> body){
            return accountService.updateAccountBalance(body);
    }

    @GetMapping("/getAll")
    public Set<Account> getAllAccounts(@RequestBody Map<String, String> body){
        return customerService.getAllAccounts(body);
    }

    @PostMapping("/transactions")
    public Set<Transaction> getAllTransactions(@RequestBody Map<String,String> body){
        String id = body.get("accountId");
        return accountService.getTransactions(id);
    }
}
