package com.epam.shop.command.impl.client;

import com.epam.shop.command.Command;
import com.epam.shop.entity.pages.Page;
import com.epam.shop.entity.pages.impl.BackPage;
import com.epam.shop.entity.pages.impl.client.ClientProfilePage;
import com.epam.shop.reader.Reader;
import com.epam.shop.service.UserService;
import com.epam.shop.session.Session;

public class ChangeUserNameCommand implements Command {
    @Override
    public Page execute() {
        UserService service = new UserService();

        System.out.println("Enter new name");
        String newUserName = Reader.nextString();
        service.changeUserName(Session.getCurrUserId(),newUserName);

        return new BackPage();
    }
}
