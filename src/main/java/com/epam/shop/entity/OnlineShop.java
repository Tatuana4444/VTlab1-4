package com.epam.shop.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class OnlineShop {
    /**
     * List of products
     */
    @JacksonXmlElementWrapper(localName = "products")
    private List<Product> product;
    /**
     * List of users
     */
    @JacksonXmlElementWrapper(localName = "users")
    private List<User> user;
    /**
     * List of orders
     */
    @JacksonXmlElementWrapper(localName = "basket")
    private List<Order> order;

    /**
     * Constructor that initialize list of products, users and orders
     */
    public OnlineShop() {
        product= new ArrayList<>();
        user= new ArrayList<>();
        order = new ArrayList<>();
    }

    /**
     * Getter fot products
     * @return list of product
     */
    public List<Product> getProduct() {
        return product;
    }

    /**
     * Setter for products
     * @param value list of products
     */
    public void setProduct(List<Product> value) {
        this.product = value;
    }

    /**
     * Getter fot users
     * @return list of users
     */
    public List<User> getUser() {
        return user;
    }

    /**
     * Setter for users
     * @param value list of users
     */
    public void setUser(List<User> value) {
        this.user = value;
    }

    /**
     * Getter for orders
     * @return list or orders
     */
    public List<Order> getOrder() {
        return order;
    }

    /**
     * Setter for orders
     * @param order list of orders
     */
    public void setOrder(List<Order> order) {
        this.order = order;
    }
    /**
     * Compare object with this onlineShop
     * @param o object with which it will be compare
     * @return it will return true if objects are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OnlineShop that = (OnlineShop) o;
        return Objects.equals(product, that.product) &&
                Objects.equals(user, that.user) &&
                Objects.equals(order, that.order);
    }
    /**
     * Do hash code
     * @return hash code of onlineShop
     */
    @Override
    public int hashCode() {
        return Objects.hash(product, user, order);
    }
}
