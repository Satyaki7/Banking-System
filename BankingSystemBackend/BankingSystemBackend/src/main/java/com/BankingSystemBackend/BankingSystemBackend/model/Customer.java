package com.BankingSystemBackend.BankingSystemBackend.model;

import com.BankingSystemBackend.BankingSystemBackend.DAO.CustomerDAO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Component
@Scope("prototype")
@Entity
public class Customer {
    @Id
    private String id;
    private String name;
    private String password;
    @Autowired
    @OneToMany(mappedBy = "customer")
    private Set<Account> accounts = new HashSet<>();;

    public Customer() {
        this.id = generateCustomerId();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private @NotNull String generateCustomerId(){
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        StringBuilder id = new StringBuilder("@");

        // Generate 6 random letters
        for (int i = 0; i < 6; i++) {
            int index = random.nextInt(letters.length());
            id.append(letters.charAt(index));
        }

        // Generate 4 random digits
        for (int i = 0; i < 4; i++) {
            int digit = random.nextInt(10);  // 0 to 9
            id.append(digit);
        }

        return id.toString();
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }

    public String getId() {
        return id;
    }
}

