package com.epam.shop.service;

import com.epam.shop.dao.ProductDao;
import com.epam.shop.dao.UserDao;
import com.epam.shop.entity.Product;
import com.epam.shop.singelton.SingletonOnlineShop;

import java.util.*;
import java.util.stream.Collectors;

/**
 * This class implements product functions
 */
public class ProductService {

    public String getProduct(String name) {
        ProductDao productDao = new ProductDao();
        List<Product> productList = productDao.selectProducts(name);
        StringBuilder data = new StringBuilder();
        String line = "----------------------------------------------------------------------\n";
        data.append(line);
        data.append(String.format("%5s %25s %25s %10s %n", "id", "name", "description", "price"));
        data.append(line);
        for (Product p : productList) {
            data.append(String.format("%5s %25s %25s %10s %n",
                    p.getId(), p.getName(), p.getDescription(), p.getPrice()));
        }
        data.append(line);
        return data.toString();
    }

    public String getProducts() {
        ProductDao productDao = new ProductDao();
        List<Product> productList = productDao.selectProducts();
        StringBuilder data = new StringBuilder();
        String line = "----------------------------------------------------------------------\n";
        data.append(line);
        data.append(String.format("%5s %20s %20s %10s %10s %n", "id", "name", "description", "price", "status"));
        data.append(line);
        for (Product p : productList) {
            data.append(String.format("%5s %20s %20s %10s %10s %n",
                    p.getId(), p.getName(), p.getDescription(), p.getPrice(),p.getStatus()));
        }
        data.append(line);
        return data.toString();
    }

    public void SetProductAsNull(int productId) {
        ProductDao productDao = new ProductDao();
        Optional<Product> product= productDao.getProduct(productId);
        if (!product.isPresent())
            return;
        Product p = product.get();
        productDao.SetAsNull(p);
    }

    public void changeProductName(int productId, String name) {
        ProductDao dao = new ProductDao();
        dao.changeProductName(productId, name);
    }
    public void changeProductDescription(int productId, String description) {
        ProductDao dao = new ProductDao();
        dao.changeProductDescription(productId, description);
    }
    public void changeProductPrice(int productId, int price) {
        ProductDao dao = new ProductDao();
        dao.changeProductPrice(productId, price);
    }
    public void changeProductStatus(int productId, boolean status) {
        ProductDao dao = new ProductDao();
        dao.changeProductStatus(productId, status);
    }

    public void addProduct(String name, String description, int price, boolean status) {
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setStatus(status);
    }
}
