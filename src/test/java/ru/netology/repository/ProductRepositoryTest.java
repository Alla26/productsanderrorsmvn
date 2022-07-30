package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.repository.NotFoundException;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

public class ProductRepositoryTest {

    ProductRepository repo = new ProductRepository();

    Product product1 = new Book(0, "Книга1", 1000, "Автор1");
    Product product2 = new Book(1, "Книга2", 10, "Автор2");
    Product product3 = new Book(2, "Книга3", 400, "Автор3");
    Product product4 = new Smartphone(3, "Телефон1", 15_000, "Производитель1");
    Product product5 = new Smartphone(4, "Телефон2", 60_000, "Производитель2");
    Product product6 = new Smartphone(5, "Телефон3", 100_000, "Производитель3");

    @BeforeEach
    public void setup() {
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);
        repo.save(product5);
        repo.save(product6);
    }

    @Test

    public void shouldSaveProduct() {

        Product[] expected = {product1, product2, product3, product4, product5, product6};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotSaveProductDouble() {


        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repo.save(product1);
        });

    }

    @Test
    public void shouldReturnAllProducts() {

        Product[] expected = {product1, product2, product3, product4, product5, product6};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        Product[] expected = {product1, product2, product4, product5, product6};
        Product[] actual = repo.removeById(2);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotRemoveByIdAboveLength() {

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(9);
        });

    }


}
