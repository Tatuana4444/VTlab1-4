package com.epam.shop.command.impl.admin;

import com.epam.shop.command.Command;
import com.epam.shop.entity.pages.Page;
import com.epam.shop.entity.pages.impl.BackPage;
import com.epam.shop.reader.Reader;
import com.epam.shop.service.ProductService;

/**
 * Class that implements command add new product
 */
public class AddNewProductCommand implements Command {
    /**
     * Implements command add new product
     * @return back page
     */
    @Override
    public Page execute() {
        ProductService service = new ProductService();
        System.out.println("enter name");
        String name = Reader.nextString();
        System.out.println("enter description");
        String description = Reader.nextString();
        System.out.println("enter price");
        int price = Reader.nextInt();
        System.out.println("1 - status true");
        System.out.println("2 - status false");
        boolean status = false;
        if(Reader.nextInt()==1) {
            status = true;
        }
        service.addProduct(name, description, price, status);
        return new BackPage();
    }
}
