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

    public void addProduct(Product product) {
        products.add(product);
    }

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

    public Optional<Product> isAvailable(int productId) {
        return getProduct(productId);
    }

    public boolean changeProductName(int productId, String name) {
       return products.stream()
                .map(p->{
                    if (p.getId()==productId){
                        p.setName(name);
                        return true;
                    }
                    return false;
                })
                .count()==1;
    }
    public boolean changeProductDescription(int productId, String description) {
        return products.stream()
                .map(p->{
                    if (p.getId()==productId){
                        p.setDescription(description);
                        return true;
                    }
                    return false;
                })
                .count()==1;
    }
    public boolean changeProductPrice(int productId, int price) {
        return products.stream()
                .map(p->{
                    if (p.getId()==productId){
                        p.setPrice(price);
                        return true;
                    }
                    return false;
                })
                .count()==1;

    }
    public boolean changeProductStatus(int productId, boolean status) {
        return products.stream()
                .map(p->{
                    if (p.getId()==productId){
                        p.setStatus(status);
                        return true;
                    }
                    return false;
                })
                .count()==1;
    }
}
