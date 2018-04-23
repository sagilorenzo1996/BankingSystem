package com.ABCBank.BankingSystem.repo;

import com.ABCBank.BankingSystem.domain.Branch;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepository extends CrudRepository<Branch, Long> {
}
