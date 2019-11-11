package com.epam.shop.entity.pages.impl.admin;

import com.epam.shop.command.Command;
import com.epam.shop.command.CommandFactory;
import com.epam.shop.entity.pages.Page;
import com.epam.shop.reader.Reader;

/**
 * Implements admin home page
 */
public class AdminHomePage implements Page {
    /**
     * Show admin commands
     */
    public void show() {
        int result;
        CommandFactory commandFactory = new CommandFactory();
        while(true) {
            System.out.println("1-list of users");
            System.out.println("2-list of product");
            System.out.println("0-exit");
            result = Reader.nextInt();
            if (result <= 0 || result >2){
                break;
            }
            Command command = commandFactory.getCommand(result+2);
            Page page = command.execute();
            page.show();
        }

    }
}
