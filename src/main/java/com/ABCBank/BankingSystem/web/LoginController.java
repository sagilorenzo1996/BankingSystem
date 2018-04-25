package com.ABCBank.BankingSystem.web;

import com.ABCBank.BankingSystem.domain.Account;
import com.ABCBank.BankingSystem.domain.Employee;
import com.ABCBank.BankingSystem.domain.Login;
import com.ABCBank.BankingSystem.repo.AccountRepository;
import com.ABCBank.BankingSystem.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @CrossOrigin
    @PostMapping("/user")
    public Account userLogin(@Valid @RequestBody Login login)throws ResourceNotFoundException{
            Account account=accountRepository.findByNic(login.getUsername());
            if (account==null){
                throw new ResourceNotFoundException("account not found");
            } else {
                if (account.getPassword().equals(login.getPassword())) {
                    return account;
                } else {
                    throw new ResourceNotFoundException("incorrect credentials");
                }
            }
    }

    @CrossOrigin
    @PostMapping("/employee")
    public Employee employeeLogin(@Valid @RequestBody Login login)throws ResourceNotFoundException{
        Long empId=Long.parseLong(login.getUsername());
        Optional<Employee> employee=employeeRepository.findById(empId);
        if (employee.isPresent()==false){
            throw new ResourceNotFoundException("employee not found");
        } else {
            if (employee.get().getPassword().equals(login.getPassword())) {
                return employee.get();
            } else {
                throw new ResourceNotFoundException("incorrect credentials");
            }
        }
    }

}
