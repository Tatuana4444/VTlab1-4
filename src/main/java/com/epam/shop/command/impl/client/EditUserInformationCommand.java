package com.epam.shop.command.impl.client;

import com.epam.shop.command.Command;
import com.epam.shop.entity.pages.Page;
import com.epam.shop.entity.pages.impl.BackPage;
import com.epam.shop.reader.Reader;
import com.epam.shop.service.UserService;
import com.epam.shop.session.Session;

/**
 * Class that implements edit user information command
 */
public class EditUserInformationCommand implements Command {
    /**
     * Implements command edit user information
     * @return back page
     */
    @Override
    public Page execute() {
        UserService service = new UserService();
        boolean bool = service.isAvailable(Session.getCurrUserId());
        if (bool) {
            while (true) {
                System.out.println("1- change name");
                System.out.println("2- change login");
                System.out.println("3- change password");
                System.out.println("0- exit");
                int result = Reader.nextInt();
                if (result <= 0 || result > 3)
                    break;
                switch (result) {
                    case 1:
                        System.out.println("enter new name");
                        String name = Reader.nextString();
                        service.changeUserName(Session.getCurrUserId(), name);
                        break;
                    case 2:
                        System.out.println("enter new login");
                        String description = Reader.nextString();
                        service.changeUserLogin(Session.getCurrUserId(), description);
                        break;
                    case 3:
                        System.out.println("enter new password");
                        String password = Reader.nextString();
                        service.changeUserPassword(Session.getCurrUserId(), password);
                        break;
                }
            }
        }
        else {
            System.out.println("Incorrect id");
        }
        return new BackPage();
    }
}
