package com.ABCBank.BankingSystem.repo;

import com.ABCBank.BankingSystem.domain.ManageAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManageAccountRepository extends CrudRepository<ManageAccount, Long> {
}
