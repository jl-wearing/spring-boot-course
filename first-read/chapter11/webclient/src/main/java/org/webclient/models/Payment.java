package org.webclient.models;

public class Payment {
    private String id;
    private double amount;

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }
}
