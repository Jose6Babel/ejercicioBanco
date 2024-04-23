package org.example.controller;

import org.example.model.Account;
import org.example.model.Branch;
import org.example.service.IAccountService;
import org.example.service.IBranchService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/account")
public class AccountController {
    private final IAccountService accountService;
    private final IBranchService branchService;

    public AccountController(IAccountService accountService, IBranchService branchService) {
        this.accountService = accountService;
        this.branchService = branchService;
    }

    @GetMapping
    public void getAllAccounts (Model model) {
        List<Account> accounts = accountService.getAccounts();
        List<Branch> branches = branchService.listBranch();
        model.addAttribute("accounts", accounts);
        model.addAttribute("branches", branches);
    }

    @PostMapping
    public String createAccount (@ModelAttribute("account") Account account, Model model) {
        accountService.newAccount(account);
        return "redirect:/account";
    }

    @PutMapping
    public Account modifyAccount (@RequestBody Account accountData) {
        return accountService.updateAccount(accountData);
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
