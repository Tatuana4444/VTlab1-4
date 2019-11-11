package com.epam.shop.entity.pages.impl.client;

import com.epam.shop.command.Command;
import com.epam.shop.command.CommandFactory;
import com.epam.shop.entity.pages.Page;
import com.epam.shop.reader.Reader;
/**
 * Implements client profile page
 */
public class ClientProfilePage implements Page {
    /**
     * Show commands for client profile page
     */
    @Override
    public void show() {
        int result;
        CommandFactory commandFactory = new CommandFactory();
        while(true) {
            System.out.println("1-change information");
            System.out.println("0-exit");
            result = Reader.nextInt();
            if (result != 1){
                break;
            }
            Command command = commandFactory.getCommand(result+30);
            Page page = command.execute();
            page.show();
        }
    }
}
