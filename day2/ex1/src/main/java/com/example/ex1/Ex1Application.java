package com.example.ex1;

import com.example.ex1.model.BankAccount;
import com.example.ex1.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ex1Application implements CommandLineRunner {

    @Autowired
    private BankAccountService bankAccountService;

    public static void main(String[] args) {
        SpringApplication.run(Ex1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        var b1 = new BankAccount("000000A501C5",
                "BankAcc1",
                "Saving account",
                20000,
                "$");

        var b2 = new BankAccount("000000A502C5",
                "BankAcc2",
                "Saving account",
                10000,
                "$");

        bankAccountService.saveBankAccount(b1);
        bankAccountService.saveBankAccount(b2);
        System.out.println(bankAccountService.retrieveBankAccounts());
    }
}
