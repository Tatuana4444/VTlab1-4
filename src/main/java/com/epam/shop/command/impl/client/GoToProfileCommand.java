package com.epam.shop.command.impl.client;

import com.epam.shop.command.Command;
import com.epam.shop.entity.pages.Page;
import com.epam.shop.entity.pages.impl.client.ClientProfilePage;
import com.epam.shop.service.UserService;
import com.epam.shop.session.Session;

/**
 * Class that implements go to profile command
 */
public class GoToProfileCommand implements Command {
    /**
     * Implements command go to profile
     * @return client profile page
     */
    @Override
    public Page execute() {
        UserService service = new UserService();
        String userInfo = service.getUser(Session.getCurrUserId());
        System.out.println(userInfo);

        return new ClientProfilePage();
    }
}
