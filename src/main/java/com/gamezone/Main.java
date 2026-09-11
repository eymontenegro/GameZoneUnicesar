package com.gamezone;

import com.gamezone.service.PersonService;
import com.gamezone.service.ProductService;
import com.gamezone.service.SaleService;
import com.gamezone.ui.Menu;

public class Main {

    public static void main(String[] args) {
        // Service layer initialization (automatically loads CSV files from data/ directory)
        ProductService productService = new ProductService();
        PersonService personService = new PersonService();
        SaleService saleService = new SaleService(productService, personService);

        // UI layer initialization and execution
        Menu mainMenu = new Menu(productService, personService, saleService);
        mainMenu.start();
    }
}
