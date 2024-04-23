package org.example.service;

import org.example.model.Account;
import org.example.model.DTO.AccountDTO;

import java.util.List;

public interface IAccountService {
    List<AccountDTO> getAccounts();

    Account newAccount();

    Account updateAccount(Account accountData);

    boolean deleteAccount(String accountNumber);

    Account getAccount(String accountNumber);
}
