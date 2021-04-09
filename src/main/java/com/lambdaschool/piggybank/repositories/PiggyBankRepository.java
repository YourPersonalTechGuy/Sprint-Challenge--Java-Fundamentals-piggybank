package com.lambdaschool.piggybank.repositories;

import com.lambdaschool.piggybank.models.PiggyBankCoin;
import org.springframework.data.repository.CrudRepository;

public interface PiggyBankRepository extends CrudRepository<PiggyBankCoin, Long> {
}
