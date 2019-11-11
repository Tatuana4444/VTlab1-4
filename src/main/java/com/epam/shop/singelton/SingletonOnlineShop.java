package com.epam.shop.singelton;

import com.epam.shop.entity.OnlineShop;

import java.util.ArrayList;

/**
 * Class that implement singleton for online shop
 */
public class SingletonOnlineShop {
    /**
     * Constructor
     */
    private SingletonOnlineShop() {
    }

    /**
     * Online shop
     */
    private static OnlineShop shop;

    /**
     * Getter for online shop
     * @return online shop
     */
    public static OnlineShop getInstance() {
       if (shop == null) {
            shop = new OnlineShop();
        }
        return shop;
    }

    /**
     * Initialize shop by value
     * @param oShop value that needed to initialize OnlineShop
     */
    public static void init(OnlineShop oShop) {
        if (shop != null) {
            return;
        }
        shop = oShop;
        if (shop.getProduct()==null) {
            shop.setProduct(new ArrayList<>());
        }
        if (shop.getOrder()==null){
            shop.setOrder(new ArrayList<>());
        }
        if (shop.getUser()==null) {
            shop.setUser(new ArrayList<>());
        }
    }
}

