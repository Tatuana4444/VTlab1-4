package com.epam.shop.entity.pages.impl.client;

import com.epam.shop.command.Command;
import com.epam.shop.command.CommandFactory;
import com.epam.shop.entity.pages.Page;
import com.epam.shop.reader.Reader;

public class ClientProfilePage implements Page {
    @Override
    public void show() {
        int result;
        CommandFactory commandFactory = new CommandFactory();
        while(true) {
            System.out.println("1-change name");
            System.out.println("2-change login");
            System.out.println("3-change password");
            System.out.println("0-exit");
            result = Reader.nextInt();
            if (result <= 0 || result >3){
                break;
            }
            Command command = commandFactory.getCommand(result+30);
            Page page = command.execute();
            page.show();
        }
    }
}
