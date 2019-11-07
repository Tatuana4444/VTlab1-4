package com.epam.shop.entity.pages.impl.admin;

import com.epam.shop.command.Command;
import com.epam.shop.command.CommandFactory;
import com.epam.shop.entity.pages.Page;
import com.epam.shop.reader.Reader;

public class ClientsInformationPage implements Page {
    @Override
    public void show() {
        int result;
        CommandFactory commandFactory = new CommandFactory();
        while(true) {
            System.out.println("1-deactivate client");
            System.out.println("0-exit");
            result = Reader.nextInt();
            if (result != 1){
                break;
            }
            Command command = commandFactory.getCommand(result+3);
            Page page = command.execute();
            page.show();
        }
    }
}

