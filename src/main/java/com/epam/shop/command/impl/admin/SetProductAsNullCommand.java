package com.epam.shop.command.impl.admin;

import com.epam.shop.command.Command;
import com.epam.shop.entity.pages.Page;
import com.epam.shop.entity.pages.impl.BackPage;
import com.epam.shop.reader.Reader;
import com.epam.shop.service.ProductService;

/**
 * Class that implements set product as null command
 */
public class SetProductAsNullCommand implements Command {
    /**
     * Implements command set product as null
     * @return back page
     */
    @Override
    public Page execute() {
        ProductService service = new ProductService();
        System.out.println("enter product id");
        int productId = Reader.nextInt();
        service.SetProductAsNull(productId);
        return new BackPage();
    }
}
