package com.BankingSystemBackend.BankingSystemBackend;

import com.BankingSystemBackend.BankingSystemBackend.DAO.CustomerDAO;
import com.BankingSystemBackend.BankingSystemBackend.model.Customer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BankingSystemBackendApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BankingSystemBackendApplication.class, args);
	}

}
