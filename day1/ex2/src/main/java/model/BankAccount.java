package model;

public class BankAccount {
    private String accountNumber;
    private String name;
    private String accountType;
    private long balance;
    private String currency;

    public BankAccount(String accountNumber, String name, String accountType, long balance, String currency) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.accountType = accountType;
        this.balance = balance;
        this.currency = currency;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", name='" + name + '\'' +
                ", accountType='" + accountType + '\'' +
                ", balance=" + balance +
                ", currency='" + currency + '\'' +
                '}';
    }
}
