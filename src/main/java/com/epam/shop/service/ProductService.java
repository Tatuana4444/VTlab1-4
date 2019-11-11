package com.epam.shop.service;

import com.epam.shop.dao.ProductDao;
import com.epam.shop.entity.Product;

import java.util.List;
import java.util.Optional;

/**
 * This class implements product functions
 */
public class ProductService {
    /**
     * Find products that have in description such name
     * @param name product name
     * @return information about products that have in description such name
     */
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

    /**
     * Get products information
     * @return products information
     */
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

    /**
     * Set product with such is as null
     * @param productId product id
     */
    public void SetProductAsNull(int productId) {
        ProductDao productDao = new ProductDao();
        Optional<Product> product= productDao.getProduct(productId);
        if (!product.isPresent())
            return;
        Product p = product.get();
        productDao.SetAsNull(p);
    }

    /**
     * Edit product name
     * @param productId product id
     * @param name product  name
     */
    public void changeProductName(int productId, String name) {

        ProductDao dao = new ProductDao();
        dao.changeProductName(productId, name);
    }

    /**
     * Edit product description
     * @param productId product id
     * @param description product  description
     */
    public void changeProductDescription(int productId, String description) {
        ProductDao dao = new ProductDao();
        dao.changeProductDescription(productId, description);
    }

    /**
     * Edit product price
     * @param productId product id
     * @param price product price
     */
    public void changeProductPrice(int productId, int price) {
        ProductDao dao = new ProductDao();
        dao.changeProductPrice(productId, price);
    }

    /**
     * Edit product status
     * @param productId product id
     * @param status product status
     */
    public void changeProductStatus(int productId, boolean status) {
        ProductDao dao = new ProductDao();
        dao.changeProductStatus(productId, status);
    }

    /**
     * Add new product
     * @param name product name
     * @param description product description
     * @param price product price
     * @param status product status
     */
    public void addProduct(String name, String description, int price, boolean status) {
        ProductDao dao = new ProductDao();
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setStatus(status);
        dao.addProduct(product);

    }

    /**
     * Check product available
     * @param productId product id
     * @return true if there is product with such id, otherwise false
     */
    public boolean isAvailable(int productId) {
        ProductDao dao = new ProductDao();
        Optional<Product> product = dao.isAvailable(productId);
        return product.isPresent();
    }
}
