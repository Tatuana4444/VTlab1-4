package com.epam.shop.command;

import com.epam.shop.command.impl.LoginCommand;
import com.epam.shop.command.impl.RegisterCommand;
import com.epam.shop.command.impl.GoToHomePageCommand;
import com.epam.shop.command.impl.admin.*;
import com.epam.shop.command.impl.client.*;

/**
 * Factory for command
 */
public class CommandFactory {

    /**
     * Defined command
     * @param number number of command
     * @return command with user want do
     * guest command between 1-2
     * admin command between 3-20
     * client command between 21-35
     */
    public Command getCommand(int number) {
        switch (number) {
            case 1:
                return new LoginCommand();
            case 2:
                return new RegisterCommand();
            case 3:
                return new GoToClientInformationCommand();
            case 4:
                return  new GoToProductsInformationCommand();
            case 5:
            case 6:
            case 7:
                return new DeactivateClientCommand();
            case 8:
            case 9:
            case 10:
            case 11:
                return new AddNewProductCommand();
            case 12:
                return new SetProductAsNullCommand();
            case 13:
                return new EditProductCommand();



            case 21:
                return new ShowProductsListCommand();
            case 22:
                return new SelectProductCommand();
            case 23:
                return new GoToBasketCommand();
            case 24:
                return new GoToProfileCommand();
            case 25:
            case 26:
                return new UnselectProductCommand();
            case 27:
                return new GoToPaymentCommand();
            case 31:
                return new EditUserInformationCommand();
            default:
                return new GoToHomePageCommand();
        }
    }
}
