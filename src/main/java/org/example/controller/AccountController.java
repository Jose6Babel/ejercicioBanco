package org.example.controller;

import org.example.model.Account;
import org.example.model.DTO.AccountDTO;
import org.example.service.IAccountService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/account")
public class AccountController {
    private final IAccountService accountService;

    public AccountController(IAccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public void getAllAccounts (Model model) {
        List<AccountDTO> accounts = accountService.getAccounts();
        model.addAttribute("accounts", accounts);
    }

    @PostMapping
    public Account createAccount () {
        return accountService.newAccount();
    }

    @PutMapping
    public AccountDTO modifyAccount (@RequestBody Account accountData) {
        Account account = accountService.updateAccount(accountData);
        return new AccountDTO(account);
    }

    @PostMapping (value = "/{accountNumber}/delete")
    public boolean deleteAccount (@PathVariable String accountNumber) {
        return accountService.deleteAccount(accountNumber);
    }

    @GetMapping (value = "/{accountNumber}")
    public Account getAccount (@PathVariable String accountNumber) {
        return accountService.getAccount(accountNumber);
    }



}
