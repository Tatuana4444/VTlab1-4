package com.epam.shop.dao;

import com.epam.shop.entity.Product;
import com.epam.shop.singelton.SingletonOnlineShop;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * This class realize ProductDAO
 */
public class ProductDao {

    private List<Product> products = SingletonOnlineShop.getInstance().getProduct();

   /* public void addProduct(Product product) {
        products.add(product);
    }*/

    /*
    public Optional<Product> getProduct(String name) {
        return products.stream()
                .filter(p -> name.equals(p.getName()))
                .findFirst();
    }*/

    public Optional<Product> getProduct(int id) {
        return products.stream()
                .filter(p -> id ==p.getId() && p.getStatus())
                .findFirst();
    }
    private Optional<Product> getProductWithoutStatus(int id) {
        return products.stream()
                .filter(p -> id ==p.getId())
                .findFirst();
    }
    public List<Product> selectProducts(String name) {
        return products.stream()
                .filter(p->p.getDescription().contains(name) && p.getStatus())
                .collect(Collectors.toList());
    }

    public List<Product> selectProducts() {
        return products;
    }

    public void SetAsNull(Product p) {
        this.products.remove(p);
    }

    public void changeProductName(int productId, String name) {
        Optional<Product> product = getProduct(productId);
        if(!product.isPresent())
            return;
        product.get().setName(name);
    }
    public void changeProductDescription(int productId, String description) {
        Optional<Product> product = getProduct(productId);
        if(!product.isPresent())
            return;
        product.get().setDescription(description);
    }
    public void changeProductPrice(int productId, int price) {
        Optional<Product> product = getProduct(productId);
        if(!product.isPresent())
            return;
        product.get().setPrice(price);

    }
    public void changeProductStatus(int productId, boolean status) {
        Optional<Product> product = getProductWithoutStatus(productId);
        if(!product.isPresent())
            return;
        product.get().setStatus(status);
    }
}
