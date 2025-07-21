package com.BankingSystemBackend.BankingSystemBackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Entity
public class Account {
    @Id
    private String accountId;
    @Getter
    @Setter
    private long balance;
    @Getter
    @Setter
    @Autowired
    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    private Customer customer;
    @Getter
    private Set<String> transactions = new HashSet<>();

    public Account(){
        accountId = generateAccountId();
    }

    private String generateAccountId(){
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        StringBuilder id = new StringBuilder("#");

        // Generate 4 random letters
        for (int i = 0; i < 4; i++) {
            int index = random.nextInt(letters.length());
            id.append(letters.charAt(index));
        }

        // Generate 6 random digits
        for (int i = 0; i < 6; i++) {
            int digit = random.nextInt(10);  // 0 to 9
            id.append(digit);
        }

        return id.toString();
    }

    public void setTransactions(String s, LocalDate now) {
        this.transactions.add(s+" "+now);

    }
}
