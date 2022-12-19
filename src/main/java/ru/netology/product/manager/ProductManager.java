package ru.netology.product.manager;

import java.util.*;
import ru.netology.product.repo.ProductRepository;

public class ProductManager {

    private ProductRepository repo;

    public ProductManager(ProductRepository repo) {
        this.repo = repo;
    }

    public void add(Product product) {
        this.repo.save(product);
    }

    public Product[] findAll() {
        Product[] all = this.repo.findAll();
        return all;
    }

    public Product[] searchBy(String text) {
        List<Product> _result = new ArrayList<Product>();
        for (Product product: repo.findAll()) {
            if (matches(product, text)) {
                _result.add(product);
            }
        }

        Product[] result = new Product[_result.size()];

        for (int i = 0; i < _result.size(); i++) {
            result[i] = _result.get(i);
        }

        return result;
    }

    public boolean matches(Product product, String search) {
        return product.getName().contains(search);
    }


}
