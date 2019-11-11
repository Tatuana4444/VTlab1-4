package com.epam.shop.command.impl;

import com.epam.shop.command.Command;
import com.epam.shop.entity.User;
import com.epam.shop.entity.pages.Page;
import com.epam.shop.entity.pages.PageFactory;
import com.epam.shop.entity.pages.impl.BackPage;
import com.epam.shop.reader.Reader;
import com.epam.shop.service.UserService;
import com.epam.shop.session.Session;

import java.util.Optional;

/**
 * Class that implements login command
 */
public class LoginCommand implements Command {
    /**
     * Implements command login
     * @return back page
     */
    @Override
    public Page execute() {
        UserService service = new UserService();
        System.out.print("enter login :");
        String login = Reader.nextString();
        System.out.print("enter your password :");
        String password = Reader.nextString();
        Optional<User> user= service.login(login,password);
        if (user.isPresent()){
            User u = user.get();
            Session.setCurrUserId(u.getId());
            PageFactory factory = new PageFactory();
            return factory.getPage(u.getRole());
        }
        return new BackPage();
    }

}
