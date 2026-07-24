package com.example.__spring_data.repositories;

import com.example.__spring_data.entities.Account;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;

public interface AccountRepository extends CrudRepository<Account, Integer> {
    @Query("select * from account where name = :name")
    List<Account> findByName(String name);

    @Modifying
    @Query("update account set amount = :amount where id = :id")
    void updateAmount(Integer id, BigDecimal amount);
}
