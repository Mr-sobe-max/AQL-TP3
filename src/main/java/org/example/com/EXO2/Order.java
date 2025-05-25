package org.example.com.EXO2;

public class Order {
    private long id;
    private String productName;
    private double amount;

    public Order(long id, String productName, double amount) {
        this.id = id;
        this.productName = productName;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public double getAmount() {
        return amount;
    }
}