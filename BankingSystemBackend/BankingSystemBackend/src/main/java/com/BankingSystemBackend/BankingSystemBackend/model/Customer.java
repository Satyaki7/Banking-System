package com.BankingSystemBackend.BankingSystemBackend.model;

import com.BankingSystemBackend.BankingSystemBackend.DAO.CustomerDAO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
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
    @Getter
    @Id
    private String id;
    @Setter
    @Getter
    private String name;
    @Setter
    @Getter
    private String password;
    @Getter
    @Autowired
    @OneToMany(mappedBy = "customer")
    private Set<Account> accounts;
    @Getter
    @Setter
    private long pocketBalance;

    public Customer() {
        this.id = generateCustomerId();
        this.accounts = new HashSet<>();
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

    public void setAccounts(Account account) {
        this.accounts.add(account);
    }
}

