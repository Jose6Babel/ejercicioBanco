package org.example.model;

import org.springframework.stereotype.Repository;

@Repository
public class Account {
    private String accountNumber;
    private Branch branch;
    private Long clientId;
    private double balance;

    public Account() {

    }
    public Account(String accountNumber, Branch branch, double balance) {
        this.accountNumber = accountNumber;
        this.branch = branch;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

}
