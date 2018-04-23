package com.ABCBank.BankingSystem.repo;

import com.ABCBank.BankingSystem.domain.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long>{
    Account findByNic(String nic);
    Account findByNicAndAccountType(String nic,String type);
    Account findByNicAndPassword(String nic,String password);
}
