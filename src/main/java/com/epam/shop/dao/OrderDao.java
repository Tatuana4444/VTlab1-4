package com.epam.shop.dao;

import com.epam.shop.entity.Order;
import com.epam.shop.singelton.SingletonOnlineShop;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * This class realize UserDAO
 */
public class OrderDao {
    private List<Order> orders = SingletonOnlineShop.getInstance().getOrder();

    /**
     * Setter for user
     *
     * @param order user which need to add
     */
    public void addNewOrder(Order order) {
        this.orders.add(order);
    }

    /**
     * Set order as null
     * @param order order that needs to set as null
     */
    public void SetAsNull(Order order) {
        this.orders.remove(order);
    }

    /**
     * Find orders bu user id
     * @param id user id
     * @return order list which have such user id
     */
    public List<Order> selectOrders(int id) {
        return orders.stream()
                .filter(o->o.getUserId()==id)
                .collect(Collectors.toList());
    }

    /**
     * Find order by user id and product id
     * @param userId user id
     * @param productId product id
     * @return order which has such userId and productId or null
     */
    public Optional<Order> selectOrder(int userId, int productId) {
        return orders.stream()
                .filter(o->o.getUserId()==userId && o.getProduct().getId()==productId)
                .findFirst();
    }
}
