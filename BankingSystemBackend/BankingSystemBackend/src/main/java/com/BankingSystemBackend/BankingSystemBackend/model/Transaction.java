package com.BankingSystemBackend.BankingSystemBackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Embeddable
public class Transaction {
    @Getter
    @JsonProperty("date")
    private LocalDate date;
    @Getter
    @Setter
    private String source;
    @Getter
    @Setter
    private long amount;
    @Getter
    @Setter
    private String type;
    @Getter
    @Setter
    private String account;

    public Transaction(){
        date = LocalDate.now();
    }
}
