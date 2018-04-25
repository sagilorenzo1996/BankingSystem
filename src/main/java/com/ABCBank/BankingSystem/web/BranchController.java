package com.ABCBank.BankingSystem.web;

import com.ABCBank.BankingSystem.domain.Account;
import com.ABCBank.BankingSystem.domain.Branch;
import com.ABCBank.BankingSystem.repo.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;
import javax.validation.Valid;

@RestController
@RequestMapping("/Branch")
public class BranchController {

    @Autowired
    BranchRepository branchRepository;

    @CrossOrigin
    @PostMapping("/createBranch")
    public Branch createAccount(@Valid @RequestBody Branch branch){
        return branchRepository.save(branch);
    }
}
