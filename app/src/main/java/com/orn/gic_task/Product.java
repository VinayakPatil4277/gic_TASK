package com.orn.gic_task;

public class Product {
    private String productId;
    private String productName;
    private String description;
    private double price;
    private String imageUrl;

    public Product() {} // Needed for Firebase

    public Product(String productId, String productName, String description, double price, String imageUrl) {
        this.productId = productId;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public String getProductId() { return productId; }
    public String getProductName() { return productName; }
    public String getDescription() { return description; }
    public double getPrice() { return price; }
    public String getImageUrl() { return imageUrl; }
}
