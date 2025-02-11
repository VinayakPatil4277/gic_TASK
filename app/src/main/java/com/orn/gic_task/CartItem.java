package com.orn.gic_task;

public class CartItem {
    private String productId;
    private String productName;
    private int quantity;
    private double price;

    public CartItem() {} // Required for Firebase

    public CartItem(String productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProductId() { return productId; }
    public String getProductName() { return productName; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }

    public double getTotalPrice() {
        return price * quantity;
    }
}
