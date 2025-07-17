package com.BankingSystemBackend.BankingSystemBackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@Scope("prototype")
@Entity
public class Account {
    @Id
    private String accountId;
    private long balance;
    @Autowired
    @ManyToOne
    private Customer customer;

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
}
