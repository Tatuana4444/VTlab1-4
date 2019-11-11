package com.epam.shop.command.impl.client;

import com.epam.shop.command.Command;
import com.epam.shop.entity.pages.Page;
import com.epam.shop.entity.pages.impl.BackPage;
import com.epam.shop.reader.Reader;
import com.epam.shop.service.OrderService;
import com.epam.shop.session.Session;

/**
 * Class that implements unselect product command
 */
public class UnselectProductCommand implements Command {
    /**
     * Implements command unselect product
     * @return back page
     */
    @Override
    public Page execute() {
        OrderService service = new OrderService();
        System.out.println("enter product id");
        int productId = Reader.nextInt();
        int userId = Session.getCurrUserId();
        service.SetOrderAsNull(productId,userId);
        return new BackPage();
    }
}