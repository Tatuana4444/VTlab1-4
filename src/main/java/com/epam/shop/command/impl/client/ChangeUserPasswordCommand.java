package com.epam.shop.command.impl.client;

import com.epam.shop.command.Command;
import com.epam.shop.entity.pages.Page;
import com.epam.shop.entity.pages.impl.BackPage;
import com.epam.shop.reader.Reader;
import com.epam.shop.service.UserService;
import com.epam.shop.session.Session;

public class ChangeUserPasswordCommand implements Command {
    @Override
    public Page execute() {
        UserService service = new UserService();

        System.out.println("Enter new password");
        String newUserPassword = Reader.nextString();
        service.changeUserPassword(Session.getCurrUserId(),newUserPassword);

        return new BackPage();
    }
}
