package com.codegym.service;

import com.codegym.model.Cart;
import com.codegym.model.Product;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CartServiceImpl {

    private boolean checkItemInCart(Product product, Cart cart) {
        for (Map.Entry<Product, Integer> entry : cart.getProducts().entrySet()) {
            if (entry.getKey().getId().equals(product.getId())) {
                return true;
            }
        }
        return false;
    }

    private Map.Entry<Product, Integer> selectItemInCart(Product product, Cart cart) {
        for (Map.Entry<Product, Integer> entry : cart.getProducts().entrySet()) {
            if (entry.getKey().getId().equals(product.getId())) {
                return entry;
            }
        }
        return null;
    }

    public void addProduct(Product product, Cart cart) {
        if (!checkItemInCart(product, cart)) {
            cart.getProducts().put(product, 1);
        } else {
            Map.Entry<Product, Integer> itemEntry = selectItemInCart(product, cart);
            Integer newQuantity = itemEntry.getValue() + 1;
            cart.getProducts().put(itemEntry.getKey(), newQuantity);
        }
    }

    public void reduceProduct(Product product, Cart cart) {
        if (checkItemInCart(product, cart)) {
            if (cart.getProducts().get(product) > 1) {
                Map.Entry<Product, Integer> itemEntry = selectItemInCart(product, cart);
                cart.getProducts().put(itemEntry.getKey(), itemEntry.getValue() - 1);
            } else {
                cart.getProducts().remove(product);
            }
        }
    }

    public void removeProduct(Product product, Cart cart) {
        Map.Entry<Product, Integer> itemEntry = selectItemInCart(product, cart);
        cart.getProducts().remove(itemEntry.getKey());
    }

    public void countProductQuantity(Cart cart) {
        Integer productQuantity = 0;
        for (Map.Entry<Product, Integer> entry : cart.getProducts().entrySet()) {
            productQuantity += entry.getValue();
        }
        cart.setCountProductQuantity(productQuantity);
    }

    public void countTotalPayment(Cart cart) {
        float payment = 0;
        for (Map.Entry<Product, Integer> entry : cart.getProducts().entrySet()) {
            payment += entry.getKey().getPrice() * (float) entry.getValue();
        }
        cart.setCountTotalPayment(payment);
    }

    public void clearCart(Cart cart) {
        cart.getProducts().clear();
    }

    public void updateCart(Cart cart) {
        countProductQuantity(cart);
        countTotalPayment(cart);
    }
}

