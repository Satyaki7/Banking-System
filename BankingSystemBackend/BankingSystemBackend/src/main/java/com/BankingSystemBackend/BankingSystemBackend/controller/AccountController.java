package com.BankingSystemBackend.BankingSystemBackend.controller;

import com.BankingSystemBackend.BankingSystemBackend.model.Customer;
import com.BankingSystemBackend.BankingSystemBackend.service.AccountService;
import com.BankingSystemBackend.BankingSystemBackend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService service;
    @Autowired
    private CustomerService customerService;

    @GetMapping("/check")
    public String helloWorld(){
        System.out.println("working");
        return "hello world";
    }
}
