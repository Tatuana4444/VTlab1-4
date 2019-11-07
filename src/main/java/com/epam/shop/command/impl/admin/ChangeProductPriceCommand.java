package com.epam.shop.command.impl.admin;

import com.epam.shop.command.Command;
import com.epam.shop.entity.pages.Page;
import com.epam.shop.entity.pages.impl.BackPage;
import com.epam.shop.reader.Reader;
import com.epam.shop.service.ProductService;

public class ChangeProductPriceCommand implements Command {
    @Override
    public Page execute() {
        ProductService service = new ProductService();
        System.out.println("enter id");
        int productId = Reader.nextInt();
        System.out.println("enter new price");
        int price = Reader.nextInt();

        service.changeProductPrice(productId, price);
        return new BackPage();
    }
}
