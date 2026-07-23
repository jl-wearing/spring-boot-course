package com.example.__transactions.repositories;

import com.example.__transactions.models.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public class AccountRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AccountRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Optional<Account> getAccountById(String id) {
        String sql = "select * from account where id = ?";

        List<Account> accounts = jdbcTemplate.query(sql, (r, i) -> {
            Account account = new Account();
            account.setId(r.getString("id"));
            account.setName(r.getString("name"));
            account.setBalance(r.getBigDecimal("balance"));
            return account;
        }, id);

        return accounts.isEmpty() ? Optional.empty() : Optional.of(accounts.getFirst());
    }

    public void addAccount(Account account) {
        String sql = "insert into account (id, name, balance) values (?, ?, ?)";
        jdbcTemplate.update(sql, account.getId(), account.getName(), account.getBalance());
    }

    public void updateBalance(String id, BigDecimal amount) {
        String sql = "update account set balance = ? where id = ?";
        jdbcTemplate.update(sql, amount, id);
    }

    public List<Account> findAllAccounts() {
        String sql = "select * from account";

        return jdbcTemplate.query(sql, (r, i) -> {
            Account account = new Account();
            account.setId(r.getString("id"));
            account.setName(r.getString("name"));
            account.setBalance(r.getBigDecimal("balance"));
            return account;
        });
    }
}
