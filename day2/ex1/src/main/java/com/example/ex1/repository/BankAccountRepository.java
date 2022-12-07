package com.example.ex1.repository;

import com.example.ex1.model.BankAccount;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BankAccountRepository {

    private List<BankAccount> bankAccounts = new ArrayList<>();

    public void saveBankAccount(BankAccount bankAccount){
        bankAccounts.add(bankAccount);
    }

    public List<BankAccount> findAllBankAccounts() {
        return bankAccounts;
    }

}
