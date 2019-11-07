package com.epam.shop.command.impl.admin;

import com.epam.shop.command.Command;
import com.epam.shop.entity.pages.Page;
import com.epam.shop.entity.pages.impl.BackPage;
import com.epam.shop.reader.Reader;
import com.epam.shop.service.UserService;

public class DeactivateClientCommand implements Command {
    @Override
    public Page execute() {
        UserService service = new UserService();
        System.out.println("enter user id");
        int result= Reader.nextInt();
        service.setUserAsNull(result);

        return new BackPage();
    }
}
