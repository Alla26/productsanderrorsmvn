package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.repository.ProductRepository;

public class ProductManagerTest {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product product1 = new Book(0, "Книга1", 1000, "Автор1");
    Product product2 = new Book(1, "Книга1", 10, "Автор2");
    Product product3 = new Book(2, "Книга3", 400, "Автор3");
    Product product4 = new Smartphone(3, "Телефон1", 15_000, "Производитель1");
    Product product5 = new Smartphone(4, "Телефон2", 60_000, "Производитель2");
    Product product6 = new Smartphone(5, "Телефон3", 100_000, "Производитель3");

    @BeforeEach
    public void setup() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
        manager.add(product5);
        manager.add(product6);
    }


    @Test
    public void shouldAddProduct() {
        Product[] expected = {product1, product2, product3, product4, product5, product6};
        Product[] actual = manager.getProducts();
        //Product[]actual = manager.add(Product products);


        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindProduct() {

        Product[] expected = {product3};
        Product[] actual = manager.searchBy("Книга3");


        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindProducts() {

        Product[] expected = {product1, product2};
        Product[] actual = manager.searchBy("Книга1");


        Assertions.assertArrayEquals(expected, actual);

    }


}
