package ru.netology.domain;

import ru.netology.repository.ProductRepository;

public class ProductManager {

    private ProductRepository repo;

    public Product[] getProducts() {
        Product[] all = repo.getProducts();
        return all;
    }


    public ProductManager(ProductRepository repo) {    //конструктор
        this.repo = repo;
    }


    public void add(Product product) {                 //добавляет продукты
        repo.save(product);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];// тут будем хранить подошедшие запросу продукты
        for (Product product : repo.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = product;
                result = tmp;
                // "добавляем в конец" массива result продукт product
            }
        }
        return result;
    }

    // метод определения соответствия товара product запросу search
    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
        // или в одну строку: return product.getName().contains(search);
    }


     /*public Product[] searchBy(String text) {
        Product[] result = new Product[0];// тут будем хранить подошедшие запросу продукты
        for (Product product : repo.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                //    tmp[i] = result[i];

                }
                tmp[tmp.length - 1] = product;
                result = tmp;
                // "добавляем в конец" массива result продукт product
            }
        }
        return result;
    }*/

}
