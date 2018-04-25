package com.ABCBank.BankingSystem.web;

import com.ABCBank.BankingSystem.domain.Account;
import com.ABCBank.BankingSystem.repo.AccountRepository;
import com.ABCBank.BankingSystem.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;
import java.lang.String;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityExistsException;
import javax.validation.Valid;

@RestController
@RequestMapping("/Account")
public class AccountController {

    @Autowired
    AccountRepository accountRepository;

    @CrossOrigin
    @PostMapping("/createAccount")
    public Account createAccount(@Valid @RequestBody Account account)throws EntityExistsException{
        Account duplicate=accountRepository.findByNicAndAccountType(account.getNic(),account.getAccountType());
        if(duplicate!=null){
            throw new EntityExistsException(duplicate.getNic()+" is already registered with a"+ duplicate.getAccountType()+" account");
        }
        return accountRepository.save(account);
    }

    @CrossOrigin
    @DeleteMapping("/deleteAccount/{id}")
    public void deleteAccount(@PathVariable Long id)throws ResourceNotFoundException{
        Optional<Account> account=accountRepository.findById(id);
        if(account.isPresent()==false){
            throw new ResourceNotFoundException("account does not exist");
        }
        accountRepository.delete(account.get());
    }

    @CrossOrigin
    @PutMapping("/update/{id}")
    public Account updateAccount(@PathVariable Long id)throws ResourceNotFoundException{
        Optional<Account> account=accountRepository.findById(id);
        if(account.isPresent()==false){
            throw new ResourceNotFoundException("account not found");
        }
        return accountRepository.save(account.get());
    }

    @CrossOrigin
    @GetMapping("/{nic}")
    public Account getAccountDetailsByNic(@PathVariable(value = "nic") String nic)throws ResourceNotFoundException{
        Account account = accountRepository.findByNic(nic);
        if(account==null){
            throw new ResourceNotFoundException(nic+" is not registered with our bank");
        }
        return account;
    }

    @CrossOrigin
    @DeleteMapping("/delete/{nic}")
    public void deleteAccountByNic(@PathVariable(value = "nic") String nic)throws ResourceNotFoundException{
        Account account=accountRepository.findByNic(nic);
        if(account==null){
            throw new ResourceNotFoundException("Account cannot be found");
        }
        accountRepository.delete(account);
    }


}
