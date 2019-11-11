package com.epam.shop.command.impl;

import com.epam.shop.command.Command;
import com.epam.shop.entity.pages.Page;
import com.epam.shop.entity.pages.impl.BackPage;

/**
 * Class that implement command go to home page
 */
public class GoToHomePageCommand implements Command {
    /**
     * Implements command go to home page
     * @return back page
     */
    @Override
    public Page execute() {
        return new BackPage();
    }
}
