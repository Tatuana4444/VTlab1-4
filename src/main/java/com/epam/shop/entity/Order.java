package com.epam.shop.entity;

import java.util.Objects;

public class Order extends Entity{
    /**
     * Product
     */
    private Product product;
    /**
     * quantity of product
     */
    private int quantity;
    /**
     * user id that has this order
     */
    private int userId;

    /**
     * Getter for product
     * @return product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Setter for product
     * @param product product that needs to set
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * Getter for quantity
     * @return product quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Setter for quantity
     * @param quantity product quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Getter for user id
     * @return user id
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Setter for user id
     * @param userId user id
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Compare object with this order
     * @param o object with which it will be compare
     * @return it will return true if objects are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Order order = (Order) o;
        return quantity == order.quantity &&
                userId == order.userId &&
                Objects.equals(product, order.product);
    }
    /**
     * Do hash code
     * @return hash code of order
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), product, quantity, userId);
    }
}
