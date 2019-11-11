package com.epam.shop.command.impl.client;

import com.epam.shop.command.Command;
import com.epam.shop.entity.pages.Page;
import com.epam.shop.entity.pages.impl.BackPage;
import com.epam.shop.reader.Reader;
import com.epam.shop.service.OrderService;
import com.epam.shop.session.Session;

/**
 * Class that implements go to payment page
 */
public class GoToPaymentCommand implements Command {
    /**
     * Implements command go to payment
     * @return back page
     */
    @Override
    public Page execute() {
        OrderService orderService = new OrderService();

        int userId = Session.getCurrUserId();
        int totalPrice = orderService.getTotalPrice(userId);
        System.out.println("Total price " + totalPrice);
        System.out.println("1 - pay");
        System.out.println("0 - exit");
        int result = Reader.nextInt();
        if (result == 1) {
            orderService.SetOrdersAsNull(userId);
        }
        return new BackPage();
    }
}
