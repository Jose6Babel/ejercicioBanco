package org.example.repository;

import org.example.exceptions.AccountException;
import org.example.model.Account;

import java.util.List;

public interface IAccountDB {


    List<Account> getAccounts();

    Account createAccount();

    Account updateAccount(Account account, Account updatedAccount);

    Account findAccountByAccountNumber (String accountNumber) throws AccountException;
}
