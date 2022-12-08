package ru.netology.product.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.product.manager.Book;
import ru.netology.product.manager.Product;
import ru.netology.product.manager.ProductManager;
import ru.netology.product.manager.Smartphone;
import ru.netology.product.repo.ProductRepository;

public class ProductRepositoryTest {

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
    repo.save(item1);
    repo.save(item2);
    repo.save(item3);
    repo.save(item4);
    repo.save(item5);

}

@Test

    public void shouldFindAll() {
    Product[] expected = {item1, item2, item3, item4, item5};
    Product[] actual = repo.findAll();
    Assertions.assertArrayEquals(expected, actual);
}

@Test

    public void shouldSaveProduct() {
    Product[] expected = {item1, item2, item3, item4, item5, item6};
    repo.save(item6);
    Product[] actual = repo.findAll();

    Assertions.assertArrayEquals(expected, actual);
}

@Test

    public void shouldDeleteById() {
    Product[] expected = {item1, item2, item3, item5};
    repo.deleteById(04);
    Product[] actual = repo.findAll();

    Assertions.assertArrayEquals(expected, actual);

}





}
