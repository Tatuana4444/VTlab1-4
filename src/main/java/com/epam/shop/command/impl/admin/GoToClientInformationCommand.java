package com.epam.shop.command.impl.admin;

import com.epam.shop.command.Command;
import com.epam.shop.entity.pages.Page;
import com.epam.shop.entity.pages.impl.admin.ClientsInformationPage;
import com.epam.shop.service.UserService;

public class GoToClientInformationCommand implements Command {
    @Override
    public Page execute() {
        UserService service = new UserService();
        String result = service.getClients();
        System.out.println(result);
        return new ClientsInformationPage();
    }
}

