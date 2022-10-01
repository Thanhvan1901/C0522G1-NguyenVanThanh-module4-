package com.codegym.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> products = new HashMap<>();
    private Integer countProductQuantity;
    private float countTotalPayment;

    public Cart() {
    }

    public Cart(Map<Product, Integer> products) {
        this.products = products;
    }

    public float getCountTotalPayment() {
        return countTotalPayment;
    }

    public void setCountTotalPayment(float countTotalPayment) {
        this.countTotalPayment = countTotalPayment;
    }


    public Map<Product, Integer> getProducts() {
        return products;
    }

    public Integer getCountProductQuantity() {
        return countProductQuantity;
    }

    public void setCountProductQuantity(Integer countProductQuantity) {
        this.countProductQuantity = countProductQuantity;
    }

    public Integer countItemQuantity() {
        return products.size();
    }

}