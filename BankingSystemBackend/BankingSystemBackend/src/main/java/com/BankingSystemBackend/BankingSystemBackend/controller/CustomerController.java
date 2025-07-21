package com.BankingSystemBackend.BankingSystemBackend.controller;

import com.BankingSystemBackend.BankingSystemBackend.model.Account;
import com.BankingSystemBackend.BankingSystemBackend.model.Customer;
import com.BankingSystemBackend.BankingSystemBackend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping("/check")
    public String helloWorld(){
        System.out.println("working");
        return "hello world";
    }

    @GetMapping("/All")
    public List<Customer> returningAll(){
        return service.findAll();
    }

    @PostMapping("/createCustomer")
    public boolean creatingCustomer(@RequestBody Customer customer){
        System.out.println("Service triggered.");
        return service.createCustomer(customer);
    }

    @PostMapping("/Login")
    public List<String> loginCustomer(@RequestBody Customer customer){
        System.out.println("Service triggered");
        return service.findCustomer(customer);
    }
}
