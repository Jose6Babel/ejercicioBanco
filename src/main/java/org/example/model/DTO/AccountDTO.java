package org.example.model.DTO;

import org.example.model.Account;

public class AccountDTO {
    private String accountNumber;
    private double balance;

    public AccountDTO(Account account) {
        this.accountNumber = account.getAccountNumber();
        this.balance = account.getBalance();
    }
}
