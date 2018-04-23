package com.ABCBank.BankingSystem.repo;

import com.ABCBank.BankingSystem.domain.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
