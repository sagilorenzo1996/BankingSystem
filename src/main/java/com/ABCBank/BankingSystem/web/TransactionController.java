package com.ABCBank.BankingSystem.web;

import com.ABCBank.BankingSystem.domain.HandleAccount;
import com.ABCBank.BankingSystem.repo.AccountRepository;
import com.ABCBank.BankingSystem.repo.EmployeeRepository;
import com.ABCBank.BankingSystem.repo.HandleAccountRepository;
import com.ABCBank.BankingSystem.repo.ManageAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/action")
public class TransactionController {

    @Autowired
    HandleAccountRepository handleAccountRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    ManageAccountRepository manageAccountRepository;


    @PostMapping("/handleAccount")
    public HandleAccount getAllHandling(@Valid @RequestBody HandleAccount handleAccount){
        return handleAccountRepository.save(handleAccount);
    }

    @PostMapping("/withdraw/{accId}/{type}/{amount}/{empId}")
    public String withdraw(@PathVariable Long accId)
}
