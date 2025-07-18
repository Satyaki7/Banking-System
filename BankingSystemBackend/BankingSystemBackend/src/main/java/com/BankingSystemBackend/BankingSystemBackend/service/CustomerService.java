package com.BankingSystemBackend.BankingSystemBackend.service;

import com.BankingSystemBackend.BankingSystemBackend.DAO.AccountDAO;
import com.BankingSystemBackend.BankingSystemBackend.DAO.CustomerDAO;
import com.BankingSystemBackend.BankingSystemBackend.model.Account;
import com.BankingSystemBackend.BankingSystemBackend.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerDAO dao;
    @Autowired
    private AccountService accountService;

    public List<Customer> findAll() {
        return dao.findAll();
    }

    public boolean createCustomer(Customer customer) {
        if ((dao.findByName(customer.getName())).isEmpty()){
            customer.setPocketBalance(1000);
            Account ac = accountService.createAccount();
            customer.setAccounts(ac);
            dao.save(customer);
            return true;
        }else return false;
    }

    public List<String> findCustomer(Customer customer) {
        /*
        * 0 if no account found
        * 1 if password matches
        * 2 if wrong password
        * */
        List<String> a = new ArrayList<>();
        if (!dao.findByName(customer.getName()).isEmpty()){
            Customer fetchedCustomer =  (dao.findByName(customer.getName())).getFirst();
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
}
