package com.epam.shop.command.impl.admin;

import com.epam.shop.command.Command;

import com.epam.shop.entity.pages.Page;
import com.epam.shop.entity.pages.impl.BackPage;
import com.epam.shop.reader.Reader;
import com.epam.shop.service.ProductService;

/**
 * Class that implements command edit product
 */
public class EditProductCommand implements Command {
    /**
     * Implements command edit product name, description, price or state
     * @return back page
     */
    @Override
    public Page execute() {
        ProductService service = new ProductService();
        System.out.println("enter id");
        int productId = Reader.nextInt();
        boolean bool = service.isAvailable(productId);
        if (bool) {
            while (true) {
                System.out.println("1- change name");
                System.out.println("2- change description");
                System.out.println("3- change price");
                System.out.println("4- change status");
                System.out.println("0- exit");
                int result = Reader.nextInt();
                if (result <= 0 || result > 4)
                    break;
                switch (result) {
                    case 1:
                        System.out.println("enter new name");
                        String name = Reader.nextString();
                        service.changeProductName(productId, name);
                        break;
                    case 2:
                        System.out.println("enter new description");
                        String description = Reader.nextString();
                        service.changeProductDescription(productId, description);
                        break;
                    case 3:
                        System.out.println("enter new price");
                        int price = Reader.nextInt();
                        service.changeProductPrice(productId, price);
                        break;
                    case 4:
                        System.out.println("0- status false");
                        System.out.println("1- status true");
                        int status = Reader.nextInt();
                        if (status == 1)
                            service.changeProductStatus(productId, true);
                        else
                            service.changeProductStatus(productId, false);
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
