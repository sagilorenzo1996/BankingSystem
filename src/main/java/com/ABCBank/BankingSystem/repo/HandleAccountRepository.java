package com.ABCBank.BankingSystem.repo;

import com.ABCBank.BankingSystem.domain.HandleAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HandleAccountRepository extends CrudRepository<HandleAccount, Long> {
}
