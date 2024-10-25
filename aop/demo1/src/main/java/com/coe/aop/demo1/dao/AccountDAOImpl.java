package com.coe.aop.demo1.dao;

import org.springframework.stereotype.Repository;

import com.coe.aop.demo1.model.Account;

@Repository
public class AccountDAOImpl implements AccountDAO {
    int balance = 20;

    @Override
    public void addAccount(Account acc) {
        System.out.println("Saving Account...");
        // Do some stub

        System.out.println("Saved Account.");
        // End.
    }
    
    public boolean withdraw(int amount) {
        if (balance < amount) {
            return false;
        } 
        balance = balance - amount;
        return true;
    }
}
