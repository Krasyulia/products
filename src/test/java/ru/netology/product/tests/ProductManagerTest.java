package ru.netology.product.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.product.manager.Book;
import ru.netology.product.manager.Product;
import ru.netology.product.manager.ProductManager;
import ru.netology.product.manager.Smartphone;
import ru.netology.product.repo.ProductRepository;

public class ProductManagerTest {

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Book item1 = new Book(01, "Незнайка", 200, "Носов");
    Book item2 = new Book(02, "Идиот", 500, "Достоевский");
    Book item3 = new Book(03, "Фауст", 700, "Гёте");
    Smartphone item4 = new Smartphone(04, "Galaxy S10", 70000, "Samsung");
    Smartphone item5 = new Smartphone(05, "Note 9 pro", 20000, "Xiaomi");
    Smartphone item6 = new Smartphone(06, "iPhone X", 40000, "Apple");

    @BeforeEach

    public void setup() {
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);
    }

    @Test

    public void shouldAddProduct() {
        Product[] expected = {item1, item2, item3, item4, item5, item6};
        manager.add(item6);
        Product[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldSearchBy() {
        Product[] expected = {item1};
        Product[] actual = manager.searchBy("Незнайка");

        Assertions.assertArrayEquals(expected, actual);
    }
}
