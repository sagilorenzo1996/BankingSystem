package com.ABCBank.BankingSystem.web;

import com.ABCBank.BankingSystem.domain.*;
import com.ABCBank.BankingSystem.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.Optional;

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

    @Autowired
    BranchRepository branchRepository;


    @PostMapping("/handleAccount")
    public HandleAccount getAllHandling(@Valid @RequestBody HandleAccount handleAccount){
        return handleAccountRepository.save(handleAccount);
    }

    @PostMapping("/withdraw/{accId}/{type}/{amount}/{empId}")
    public ManageAccount withdraw(@PathVariable Long accId, @PathVariable String type, @PathVariable BigDecimal amount, @PathVariable Long empId)throws ResourceNotFoundException{
        Optional<Account> account=accountRepository.findById(accId);
        Optional<Employee> employee =employeeRepository.findById(empId);
        ManageAccount withdraw=new ManageAccount();
        HandleAccount handleAccount=new HandleAccount();
        if(account.isPresent()==false){
            throw new ResourceNotFoundException("account not found");
        }
        if(employee.isPresent()==false){
            throw new ResourceNotFoundException("employee not found");
        }
        Optional<Branch> branch=branchRepository.findById(employee.get().getBranchId());
        BigDecimal balance=account.get().getBalance().subtract(amount);
        if(balance.signum()<0){
            throw new ResourceNotFoundException("balance less than zero");
        }
        withdraw.setAccountId(account.get().getId());
        withdraw.setBranchId(branch.get().getId());
        withdraw.setAmount(amount);
        withdraw.setType(type);
        withdraw.setBranchId(branch.get().getId());
        withdraw.setDepositorName("withdraw");
        withdraw.setDepositorNic("withdraw");
        manageAccountRepository.save(withdraw);

        account.get().setBalance(balance);
        accountRepository.save(account.get());

        handleAccount.setAccountId(account.get().getId());
        handleAccount.setEmployeeId(employee.get().getId());

        handleAccountRepository.save(handleAccount);
        return withdraw;
    }

    @PostMapping("/deposit/{accountId}/{depositorName}/{depositorNic}/{amount}/{employeeId}")
    public ManageAccount deposit(@PathVariable Long accountId, @PathVariable String depositorName,@PathVariable String depositorNic, @PathVariable BigDecimal amount, @PathVariable Long employeeId)throws ResourceNotFoundException{
        Optional<Account> account=accountRepository.findById(accountId);
        Optional<Employee> employee =employeeRepository.findById(employeeId);
        ManageAccount deposit=new ManageAccount();
        HandleAccount handleAccount=new HandleAccount();
        if(account.isPresent()==false){
            throw new ResourceNotFoundException("acccount not found");
        }
        if(employee.isPresent()==false){
            throw new ResourceNotFoundException("employee not found");
        }
        Optional<Branch> branch=branchRepository.findById(employee.get().getBranchId());

        deposit.setAccountId(account.get().getId());
        deposit.setBranchId(branch.get().getId());
        deposit.setAmount(amount);
        deposit.setType("deposit");
        deposit.setBranchId(branch.get().getId());
        deposit.setDepositorName(depositorName);
        deposit.setDepositorNic(depositorNic);
        manageAccountRepository.save(deposit);

        BigDecimal balance=account.get().getBalance().add(amount);
        account.get().setBalance(balance);
        accountRepository.save(account.get());

        handleAccount.setAccountId(account.get().getId());
        handleAccount.setEmployeeId(employee.get().getId());

        handleAccountRepository.save(handleAccount);
        return deposit;
    }


}
