package com.example.ex1.repository;

import com.example.ex1.model.BankAccount;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public record BankAccountRepository(List<BankAccount> bankAccounts) {

    public BankAccount saveBankAccount(BankAccount bankAccount) {
        bankAccounts.add(bankAccount);
        return bankAccount;
    }

    public BankAccount findBankAccountByAccountName(String accountName) {
        var bankAccount = bankAccounts.stream()
                .filter(bt -> bt.getName().equalsIgnoreCase(accountName))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Bank account not found!"));

        return bankAccount;
    }

    public List<BankAccount> findAllBankAccounts() {
        return bankAccounts;
    }

}
