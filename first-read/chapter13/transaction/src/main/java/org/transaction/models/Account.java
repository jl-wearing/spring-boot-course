package org.transaction.models;

import java.math.BigDecimal;
import java.util.Objects;

public class Account {
    private long id;
    private String name;
    private BigDecimal amount;

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return this.getClass().getName() + "[ID: " + this.id + ", Name: " + this.name + ", Amount: " + this.amount + "]";
    }

    public boolean equals(Object other) {
        if (this == other) { return true; }
        if (other == null || getClass() != other.getClass()) { return false; }

        // Safely cast to account.
        Account account = (Account)other;
        return account.id == this.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.amount);
    }
}
