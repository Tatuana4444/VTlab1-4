package com.epam.shop.entity.pages.impl.admin;

import com.epam.shop.command.Command;
import com.epam.shop.command.CommandFactory;
import com.epam.shop.entity.pages.Page;
import com.epam.shop.reader.Reader;

public class ProductsInformationPage implements Page {
    @Override
    public void show() {
        int result;
        CommandFactory commandFactory = new CommandFactory();
        while(true) {
            System.out.println("1-add product");
            System.out.println("2-set as null product");
            System.out.println("3-change product");
            System.out.println("0-exit");
            result = Reader.nextInt();
            if (result <= 0 || result >6){
                break;
            }
            Command command = commandFactory.getCommand(result+10);
            Page page = command.execute();
            page.show();
        }

    }
}
