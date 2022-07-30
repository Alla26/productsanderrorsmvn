package ru.netology.repository;

import ru.netology.repository.NotFoundException;
import ru.netology.domain.Product;

public class ProductRepository {

    private Product[] products = new Product[0];

    public Product[] getProducts() {
        return products;
    }

    public Product[] save(Product product) {             //сохраняет продукт

        int id = product.getId();
        if (checkIdByAdd(id) == null) {                    //задвоение
            throw new AlreadyExistsException(
                    "Товар с таким ID уже существует:   " + id);
        }
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = product;
        products = tmp;
        return tmp;
    }

    public Product[] checkIdByAdd(int id) {
        Product[] tmp = new Product[1];
        int copyToIndex = 0;
        for (Product product : products) {
            if (product.getId() == id) {
                return null;
            }
        }
        return products;
    }

    public Product[] findAll() {                          //возвращает все продукты
        Product[] all = getProducts();
        Product[] list = new Product[all.length];
        for (int i = 0; i < list.length; i++) {
            list[i] = all[i];
        }
        return list;
    }

    public Product[] removeById(int id) {//удаляет продукты по ID
        /* String result = null;*/
        /* findById(int id);*/
        if (findById(id) == null) {
            throw new NotFoundException(
                    "Товар с указанным ID не найден: " + id
            );
        }
        Product[] tmp = new Product[products.length - 1];
        int copyToIndex = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
        }
        products = tmp;
        return tmp;
    }


    public Product[] findById(int id) {             //исходник файнд
        Product[] tmp = new Product[1];
        int copyToIndex = 0;
        for (Product product : products) {
            if (product.getId() == id) {
                tmp[copyToIndex] = product;
                copyToIndex++;

                // products = tmp;
                return products;
            }
        }
        return null;
    }

    /* public Product[] findById(int id) {
        Product[] tmp = new Product[products.length];
        int copyToIndex = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[copyToIndex] = product;
                copyToIndex++;

              /*  products = tmp;*/
    //        return products;
    //         }
    //   }
    //     return null;
    //   }*/


   /* public Product[] removeById(int id) {                    // исходник удаляет продукты по ID
        Product[] tmp = new Product[products.length - 1];
        int copyToIndex = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
        }
        products = tmp;
        return tmp;
    }*/


   /* public Product[] findByDyId(int id) {
        Product[] tmp = new Product[1];
        int copyToIndex = 0;
        for (Product product : products) {
            if (product.getId() == id) {
                tmp[copyToIndex] = product;
                copyToIndex++;

                products = tmp;
                return products;
            } /*else {
                products = null;
                return products;
            }*/
    //    }
    /* return;*/
    //      return null /*products*/;
    // }

     /* public void save(Product product) {                      //сохраняет продукт
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = product;
        products = tmp;
    }*/


}
