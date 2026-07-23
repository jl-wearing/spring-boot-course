package com.example.__data_source.repositories;

import com.example.__data_source.models.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PurchaseRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PurchaseRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createPurchase(Purchase purchase) {
        String sql = "insert into purchase (name, price) values (?, ?)";
        jdbcTemplate.update(sql, purchase.name(), purchase.price());
    }

    public List<Purchase> findAllPurchases(){
        String sql = "select * from purchase";

        // Define a rowmapper.
        RowMapper<Purchase> rowMapper = (r, i) -> {
            return new Purchase(r.getString("name"), r.getDouble("price"));
        };

        return jdbcTemplate.query(sql, rowMapper);
    }
}
