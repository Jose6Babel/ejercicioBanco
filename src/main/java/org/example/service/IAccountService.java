package org.example.service;

import org.example.model.Account;

import java.util.List;

public interface IAccountService {
    List<Account> getAccounts();

    Account newAccount(Account account);

    Account updateAccount(Account accountData);

    boolean deleteAccount(String accountNumber);

    Account getAccount(String accountNumber);
}
