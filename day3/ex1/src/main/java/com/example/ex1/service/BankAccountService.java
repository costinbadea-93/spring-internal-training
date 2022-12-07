package com.example.ex1.service;

import com.example.ex1.model.BankAccount;
import com.example.ex1.repository.BankAccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record BankAccountService(BankAccountRepository bankAccountRepository) {

    private static final Logger LOGGER = LoggerFactory.getLogger(BankAccountService.class);

    public BankAccount saveBankAccount(BankAccount bankAccount) {
        LOGGER.info("Saving to db a new bankAccount: {}", bankAccount);
        if (bankAccount.getBalance() < 0) {
            throw new RuntimeException("Bank Account balance cannot be lower than 0");
        }
        return bankAccountRepository.saveBankAccount(bankAccount);
    }

    public List<BankAccount> retrieveBankAccounts() {
        var bankAccounts = bankAccountRepository.findAllBankAccounts();
        LOGGER.info("Retrieving from repo: {}", bankAccounts);
        return bankAccounts;
    }

    public BankAccount retrieveBankAccountByName(String bankAccountName){
        LOGGER.info("Retrieving from repo bank account with name: {}", bankAccountName);
        return bankAccountRepository.findBankAccountByAccountName(bankAccountName);
    }
}
