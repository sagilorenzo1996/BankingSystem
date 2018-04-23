package com.ABCBank.BankingSystem.services;

import com.ABCBank.BankingSystem.domain.Account;
import com.ABCBank.BankingSystem.repo.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public AccountService() {

    }

    public String loginService(String nic, String password){
        Account account=accountRepository.findByNicAndPassword(nic,password);
        if (account!=null){
            return "login success";
        }
        else {
            return "login fail";
        }
    }

    public Iterable<Account> viewAllAccounts(){
        return accountRepository.findAll();
    }

}
