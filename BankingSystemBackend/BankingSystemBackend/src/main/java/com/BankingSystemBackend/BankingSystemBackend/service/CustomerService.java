package com.BankingSystemBackend.BankingSystemBackend.service;

import com.BankingSystemBackend.BankingSystemBackend.DAO.AccountDAO;
import com.BankingSystemBackend.BankingSystemBackend.DAO.CustomerDAO;
import com.BankingSystemBackend.BankingSystemBackend.model.Account;
import com.BankingSystemBackend.BankingSystemBackend.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerService {

    @Autowired
    private CustomerDAO customerDAO;
    @Autowired
    private AccountService accountService;

    public List<Customer> findAll() {
        return customerDAO.findAll();
    }

    public Customer createCustomer(Customer customer) {
        if ((customerDAO.findByName(customer.getName())).isEmpty()){
            customer.setPocketBalance(1000);
            customerDAO.save(customer);
            return customer;
        }else return null;
    }

    public List<String> findCustomer(Customer customer) {
        /*
        * 0 if no account found
        * 1 if password matches
        * 2 if wrong password
        * */
        List<String> a = new ArrayList<>();
        if (!customerDAO.findByName(customer.getName()).isEmpty()){
            Customer fetchedCustomer =  (customerDAO.findByName(customer.getName())).getFirst();
            if(fetchedCustomer.getPassword().equals(customer.getPassword())){
                a.add("1");
                a.add(fetchedCustomer.getId());
                return a;
            }else{
                a.add("2");
                return a;
            }
        }else {
            a.add("0");
            return a;
        }
    }

    public Optional<Customer> getCustomer(String id) {
        return customerDAO.findById(id);
    }

    public Set<Account> getAllAccounts(Map<String, String> body) {
        String customerId = body.get("customerId");
        Optional<Customer> customer = getCustomer(customerId);
        if(customer.isPresent()){
            Customer customerVar = customer.get();
            return customerVar.getAccounts();
        }else{
            return null;
        }

    }
}
