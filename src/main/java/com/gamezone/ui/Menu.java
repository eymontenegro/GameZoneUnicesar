package com.gamezone.ui;

import com.gamezone.service.PersonService;
import com.gamezone.service.ProductService;
import com.gamezone.service.SaleService;

import java.util.Scanner;

public class Menu {

    private final SubMenu subMenu;
    private final Scanner scanner;

    public Menu(ProductService productService, PersonService personService, SaleService saleService) {
        this.scanner = new Scanner(System.in);
        this.subMenu = new SubMenu(productService, personService, saleService, scanner);
    }

    public void start() {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n=================================");
            System.out.println("   GAMEZONE UNICESAR - MAIN MENU ");
            System.out.println("=================================");
            System.out.println("1. Manage Products");
            System.out.println("2. Manage Persons (Clients / Sellers)");
            System.out.println("3. Manage Sales");
            System.out.println("4. Exit Application");
            System.out.print("Select an option: ");

            String input = scanner.nextLine().trim();
            switch (input) {
                case "1" -> subMenu.showProductMenu();
                case "2" -> subMenu.showPersonMenu();
                case "3" -> subMenu.showSaleMenu();
                case "4" -> {
                    System.out.println("Exiting GameZone System... Goodbye!");
                    exit = true;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
