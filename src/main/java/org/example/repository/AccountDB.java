package org.example.repository;

import org.example.exceptions.AccountException;
import org.example.model.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class AccountDB implements IAccountDB{
    private List<Account> accountRepository;

    private AccountDB() {
        this.accountRepository = new ArrayList<>();
    }

    @Override
    public List<Account> getAccounts() {
        return accountRepository;
    }

    @Override
    public Account createAccount() {
        Account account = new Account();
        accountRepository.add(account);
        return account;
    }

    @Override
    public Account updateAccount(Account account, Account updatedAccount) {

        account.setAccountNumber(updatedAccount.getAccountNumber());
        account.setBranch(updatedAccount.getBranch());
        account.setBalance(updatedAccount.getBalance());
        account.setClientId(updatedAccount.getClientId());

        return account;
    }

public Account findAccountByAccountNumber (String accountNumber) throws AccountException {
    //accountRepository.forEach(e-> e.getAccountNumber().equalsIgnoreCase(accountNumber));
    Optional<Account> account =  accountRepository
            .stream()
            .filter(acc -> acc.getAccountNumber().equalsIgnoreCase(accountNumber))
            .findFirst();
    if (account.isPresent())
        return account.get();

    throw new AccountException("Account not found");
}
}
