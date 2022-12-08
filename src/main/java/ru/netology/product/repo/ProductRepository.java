package ru.netology.product.repo;

import ru.netology.product.manager.Product;

public class ProductRepository {
    private Product[] items = new Product[0];

    public void save(Product item) {
        Product[] tmp = new Product[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = item;
        items = tmp;
    }

    public Product[] findAll() {
        Product[] all = this.items;
        return all;
    }

    public void deleteById(int removeId) {
        Product[] items = this.findAll();
        Product[] tmp = new Product[items.length - 1];
        int copyToIndex = 0;
        for (Product item : items) {
            if (item.getId() != removeId) {
                tmp[copyToIndex] = item;
                copyToIndex++;
            }
        }
        this.items = tmp;
    }


}
