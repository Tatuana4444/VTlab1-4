package com.epam.shop.command.impl.admin;

import com.epam.shop.command.Command;
import com.epam.shop.entity.pages.Page;
import com.epam.shop.entity.pages.impl.BackPage;
import com.epam.shop.reader.Reader;
import com.epam.shop.service.ProductService;

public class ChangeProductStatusCommand implements Command {
    @Override
    public Page execute() {
        ProductService service = new ProductService();
        System.out.println("enter id");
        int productId = Reader.nextInt();
        System.out.println("1 - status true");
        System.out.println("2 - status false");
        if(Reader.nextInt()==1) {
            service.changeProductStatus(productId,true);
        }
        else {
            service.changeProductStatus(productId,false);
        }
        return new BackPage();
    }
}
