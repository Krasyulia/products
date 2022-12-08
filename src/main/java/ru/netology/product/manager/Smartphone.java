package ru.netology.product.manager;

import ru.netology.product.manager.Product;

public class Smartphone extends Product {
    private String producer;

    public Smartphone(int id, String name, int price, String producer) {
        super(id, name, price);
        this.producer = producer;
    }
}
