package com.ABCBank.BankingSystem.web;

import com.ABCBank.BankingSystem.domain.Account;
import com.ABCBank.BankingSystem.domain.Employee;
import com.ABCBank.BankingSystem.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;
import javax.validation.Valid;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @CrossOrigin
    @PostMapping("/createEmployee")
    public Employee createEmployee(@Valid @RequestBody Employee employee){
        return employeeRepository.save(employee);
//        return employee;
    }


}
