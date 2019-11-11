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
    /**
     * List of product
     */
    private List<Product> products = SingletonOnlineShop.getInstance().getProduct();

    /**
     * Method that add new product to list
     * @param product product that needs to add
     */
    public void addProduct(Product product) {
        products.add(product);
    }


    /**
     * Find product by id
     * @param id product id
     * @return product that has such id or null
     */
    public Optional<Product> getProduct(int id) {
        return products.stream()
                .filter(p -> id ==p.getId() && p.getStatus())
                .findFirst();
    }

    /**
     * Find products that have such name in description
     * @param name product name
     * @return list of product which have such name in description
     */
    public List<Product> selectProducts(String name) {
        return products.stream()
                .filter(p->p.getDescription().contains(name) && p.getStatus())
                .collect(Collectors.toList());
    }

    /**
     * Select products
     * @return list of product
     */
    public List<Product> selectProducts() {
        return products;
    }

    /**
     * Set product as null
     * @param p product that needs as null
     */
    public void SetAsNull(Product p) {
        this.products.remove(p);
    }

    /**
     * Find product with such id
     * @param productId product id
     * @return product with such id or null
     */
    public Optional<Product> isAvailable(int productId) {
        return getProduct(productId);
    }

    /**
     * Edit product name
     * @param productId product id
     * @param name product name
     * @return true if change was success, otherwise false
     */
    public boolean changeProductName(int productId, String name) {
       return products.stream()
                .filter(p->{
                    if (p.getId()==productId){
                        p.setName(name);
                        return true;
                    }
                    return false;
                })
                .count()==1;
    }

    /**
     * Edit product description
     * @param productId product id
     * @param description product description
     * @return true if change was success, otherwise false
     */
    public boolean changeProductDescription(int productId, String description) {
        return products.stream()
                .filter(p->{
                    if (p.getId()==productId){
                        p.setDescription(description);
                        return true;
                    }
                    return false;
                })
                .count()==1;
    }

    /**
     * Edit product price
     * @param productId product id
     * @param price product price
     * @return true if change was success, otherwise false
     */
    public boolean changeProductPrice(int productId, int price) {
        return products.stream()
                .filter(p->{
                    if (p.getId()==productId){
                        p.setPrice(price);
                        return true;
                    }
                    return false;
                })
                .count()==1;

    }

    /**
     * Edit product status
     * @param productId product id
     * @param status product status
     * @return true if change was success, otherwise false
     */
    public boolean changeProductStatus(int productId, boolean status) {
        return products.stream()
                .filter(p->{
                    if (p.getId()==productId){
                        p.setStatus(status);
                        return true;
                    }
                    return false;
                })
                .count()==1;
    }
}
