package com.mycompany.storeprojectdb;

public final class Product {

    private String name;
    private double price;
    private int stock;
    private int id;

    public Product() {
        int id = (int) (Math.random() * 100000);
        setId(id);
    }

    public Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        int id = (int) (Math.random() * 100000);
        setId(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
