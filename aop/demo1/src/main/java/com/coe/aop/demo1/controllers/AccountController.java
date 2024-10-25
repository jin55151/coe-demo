package com.coe.aop.demo1.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coe.aop.demo1.dao.AccountDAO;
import com.coe.aop.demo1.model.Account;

@RestController
@RequestMapping("account")
public class AccountController {
    AccountDAO accountRepository;

    public AccountController(AccountDAO injecteAccountDAO) {
        accountRepository =injecteAccountDAO;
    }

    @PostMapping("create")
    public void createAccount(@RequestBody Account reqBody) {
        accountRepository.addAccount(reqBody);
    }
}
