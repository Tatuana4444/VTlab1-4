package com.epam.shop.command.impl.admin;

import com.epam.shop.command.Command;
import com.epam.shop.entity.pages.Page;
import com.epam.shop.entity.pages.impl.admin.ProductsInformationPage;
import com.epam.shop.service.ProductService;

/**
 * Class that implements do to product information page command
 */
public class GoToProductsInformationCommand implements Command {
    /**
     * Implements command do to product information page
     * @return product information page
     */
    @Override
    public Page execute() {
        ProductService service = new ProductService();
        String result = service.getProducts();
        System.out.println(result);
        return new ProductsInformationPage();
    }
}
