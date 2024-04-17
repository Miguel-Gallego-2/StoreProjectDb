/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.storeprojectdb;

import java.util.ArrayList;

public class Inventory {

    private ArrayList<Product> lstProducts = new ArrayList<>() {
    };

    public Inventory() {
    }

    public ArrayList<Product> getLstProducts() {
        return lstProducts;
    }

    public void setLstProducts(ArrayList<Product> lstProducts) {
        this.lstProducts = lstProducts;
    }

    public void createProduct(Product product, String name, double price, int stock) {
        product.setName(name);
        product.setPrice(price);
        product.setStock(stock);
    }

    public void addProduct(Product product) {
        this.lstProducts.add(product);
    }

    public void removeProduct(Product product) {
        this.lstProducts.remove(product);
    }

    public void updateProduct(Product product, String newName, double newPrice, int stock) {
        lstProducts.stream()
                .filter(p -> p.equals(product))
                .findFirst()
                .ifPresent(p -> {
                    p.setName(newName);
                    p.setPrice(newPrice);
                    p.setStock(stock);
                });
    }

    public boolean validName(String newProductName) {
        boolean isValid;
        isValid = lstProducts.stream().anyMatch(p->p.getName().equals(newProductName));
        return isValid;  
    }

    public Product getProduct(String name, double price, int stock) {
        Product selectedProduct = null;
        for (Product product : lstProducts) {
            if (product.getName().equals(name) && product.getPrice() == price && product.getStock() == stock) {
                selectedProduct = product;
                break;
            }
        }
        return selectedProduct;
    }

}
