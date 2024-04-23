package org.example.service;

import org.example.exceptions.AccountException;
import org.example.model.Account;
import org.example.repository.IAccountDB;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService implements IAccountService{

    private final IAccountDB accountDB;

    public AccountService(IAccountDB accountDB) {
        this.accountDB = accountDB;
    }

    @Override
    public List<Account> getAccounts() {
        return accountDB.getAccounts();
    }

    @Override
    public Account newAccount() {
        return accountDB.createAccount();
    }

    @Override
    public Account updateAccount(Account updatedAccountData) {
        try {
            Account account = accountDB.findAccountByAccountNumber(updatedAccountData.getAccountNumber());
            return accountDB.updateAccount(account, updatedAccountData);
        } catch (AccountException e) {
            return null;
        }
    }

    @Override
    public boolean deleteAccount(String accountNumber) {
        try {
            Account account = accountDB.findAccountByAccountNumber(accountNumber);
            accountDB.getAccounts().remove(account);
            return true;
        } catch (AccountException e) {
            return false;
        }
    }

    @Override
    public Account getAccount(String accountNumber) {
        try {
            return accountDB.findAccountByAccountNumber(accountNumber);
        } catch (AccountException e) {
            return null;
        }
    }
}
