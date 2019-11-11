package com.epam.shop.command.impl.client;

import com.epam.shop.command.Command;
import com.epam.shop.entity.pages.Page;
import com.epam.shop.entity.pages.impl.client.ClientBasketPage;
import com.epam.shop.service.OrderService;
import com.epam.shop.session.Session;

/**
 *Class that implements go to basket command
 */
public class GoToBasketCommand implements Command {
    /**
     * Implements command go to basket
     * @return client basket page
     */
    @Override
    public Page execute() {
        OrderService service = new OrderService();
        int id = Session.getCurrUserId();
        String result = service.getOrders(id);
        System.out.println(result);
        return new ClientBasketPage();
    }
}
