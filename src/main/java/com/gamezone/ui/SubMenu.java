package com.gamezone.ui;

import com.gamezone.model.Client;
import com.gamezone.model.Console;
import com.gamezone.model.Product;
import com.gamezone.model.Sale;
import com.gamezone.model.SaleDetail;
import com.gamezone.model.Seller;
import com.gamezone.model.VideoGame;
import com.gamezone.service.PersonService;
import com.gamezone.service.ProductService;
import com.gamezone.service.SaleService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubMenu {

    private final ProductService productService;
    private final PersonService personService;
    private final SaleService saleService;
    private final Scanner scanner;

    public SubMenu(ProductService productService, PersonService personService, SaleService saleService, Scanner scanner) {
        this.productService = productService;
        this.personService = personService;
        this.saleService = saleService;
        this.scanner = scanner;
    }

    // ==========================================
    // SUBMENÚ DE PRODUCTOS
    // ==========================================
    public void showProductMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n=== PRODUCT MANAGEMENT ===");
            System.out.println("1. Register Video Game");
            System.out.println("2. Register Console");
            System.out.println("3. List All Products");
            System.out.println("4. Back to Main Menu");
            System.out.print("Select an option: ");

            int option = readInt();
            switch (option) {
                case 1 -> registerVideoGame();
                case 2 -> registerConsole();
                case 3 -> listProducts();
                case 4 -> exit = true;
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    private void registerVideoGame() {
        System.out.println("\n--- Register Video Game ---");
        System.out.print("ID: ");
        String id = scanner.nextLine().trim();
        System.out.print("Title: ");
        String title = scanner.nextLine().trim();
        System.out.print("Price: ");
        double price = readDouble();
        System.out.print("Stock: ");
        int stock = readInt();
        System.out.print("Platform (e.g. PS5, PC, Switch): ");
        String platform = scanner.nextLine().trim();
        System.out.print("Genre: ");
        String genre = scanner.nextLine().trim();
        System.out.print("Age Rating (e.g. E, T, M): ");
        String ageRating = scanner.nextLine().trim();

        try {
            productService.registerVideoGame(id, title, price, stock, platform, genre, ageRating);
            System.out.println("Video Game registered successfully!");
        } catch (Exception e) {
            System.out.println("Error registering video game: " + e.getMessage());
        }
    }

    private void registerConsole() {
        System.out.println("\n--- Register Console ---");
        System.out.print("ID: ");
        String id = scanner.nextLine().trim();
        System.out.print("Title: ");
        String title = scanner.nextLine().trim();
        System.out.print("Price: ");
        double price = readDouble();
        System.out.print("Stock: ");
        int stock = readInt();
        System.out.print("Brand: ");
        String brand = scanner.nextLine().trim();
        System.out.print("Model: ");
        String model = scanner.nextLine().trim();
        System.out.print("Generation: ");
        String generation = scanner.nextLine().trim();

        try {
            productService.registerConsole(id, title, price, stock, brand, model, generation);
            System.out.println("Console registered successfully!");
        } catch (Exception e) {
            System.out.println("Error registering console: " + e.getMessage());
        }
    }

    private void listProducts() {
        System.out.println("\n--- Product Catalog ---");
        List<Product> products = productService.listAll();
        if (products.isEmpty()) {
            System.out.println("No products registered.");
            return;
        }
        for (Product p : products) {
            System.out.println("[" + p.getId() + "] " + p.describe() + " | Price: $" + p.getPrice() + " | Stock: " + p.getStock());
        }
    }

    // ==========================================
    // SUBMENÚ DE PERSONAS (CLIENTES Y VENDEDORES)
    // ==========================================
    public void showPersonMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n=== PERSON MANAGEMENT ===");
            System.out.println("1. Register Client");
            System.out.println("2. List Clients");
            System.out.println("3. List Sellers");
            System.out.println("4. Back to Main Menu");
            System.out.print("Select an option: ");

            int option = readInt();
            switch (option) {
                case 1 -> registerClient();
                case 2 -> listClients();
                case 3 -> listSellers();
                case 4 -> exit = true;
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    private void registerClient() {
        System.out.println("\n--- Register Client ---");
        System.out.print("Full Name: ");
        String name = scanner.nextLine().trim();
        System.out.print("Identification Number: ");
        String id = scanner.nextLine().trim();
        System.out.print("Phone: ");
        String phone = scanner.nextLine().trim();
        System.out.print("Email: ");
        String email = scanner.nextLine().trim();

        try {
            personService.registerClient(name, id, phone, email);
            System.out.println("Client registered successfully!");
        } catch (Exception e) {
            System.out.println("Error registering client: " + e.getMessage());
        }
    }

    private void listClients() {
        System.out.println("\n--- Registered Clients ---");
        List<Client> clients = personService.listClients();
        if (clients.isEmpty()) {
            System.out.println("No clients registered.");
            return;
        }
        for (Client c : clients) {
            System.out.println(c.getDescription() + " | ID: " + c.getIdentification() + " | Phone: " + c.getPhone());
        }
    }

    private void listSellers() {
        System.out.println("\n--- Store Sellers ---");
        List<Seller> sellers = personService.listSellers();
        if (sellers.isEmpty()) {
            System.out.println("No sellers registered.");
            return;
        }
        for (Seller s : sellers) {
            System.out.println(s.getDescription() + " | Phone: " + s.getPhone());
        }
    }

    // ==========================================
    // SUBMENÚ DE VENTAS
    // ==========================================
    public void showSaleMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n=== SALE MANAGEMENT ===");
            System.out.println("1. Register New Sale");
            System.out.println("2. List Sales History");
            System.out.println("3. Back to Main Menu");
            System.out.print("Select an option: ");

            int option = readInt();
            switch (option) {
                case 1 -> registerSale();
                case 2 -> listSales();
                case 3 -> exit = true;
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    private void registerSale() {
        System.out.println("\n--- Register New Sale ---");
        System.out.print("Enter Client Identification: ");
        String clientDoc = scanner.nextLine().trim();
        System.out.print("Enter Seller Employee Code: ");
        String sellerCode = scanner.nextLine().trim();

        List<SaleDetail> details = new ArrayList<>();
        boolean addingProducts = true;

        while (addingProducts) {
            System.out.print("\nEnter Product ID to add: ");
            String productId = scanner.nextLine().trim();

            Product targetProduct = null;
            for (Product p : productService.listAll()) {
                if (p.getId().equals(productId)) {
                    targetProduct = p;
                    break;
                }
            }

            if (targetProduct == null) {
                System.out.println("Product not found with ID: " + productId);
            } else {
                System.out.println("Selected: " + targetProduct.getTitle() + " | Current Stock: " + targetProduct.getStock());
                System.out.print("Enter Quantity: ");
                int quantity = readInt();

                try {
                    SaleDetail detail = new SaleDetail(targetProduct, quantity, targetProduct.getPrice());
                    details.add(detail);
                    System.out.println("Product added to sale details.");
                } catch (Exception e) {
                    System.out.println("Error adding detail: " + e.getMessage());
                }
            }

            System.out.print("Add another product? (y/n): ");
            String response = scanner.nextLine().trim().toLowerCase();
            if (!response.equals("y")) {
                addingProducts = false;
            }
        }

        if (details.isEmpty()) {
            System.out.println("Sale canceled: No items were added.");
            return;
        }

        try {
            Sale sale = saleService.registerSale(clientDoc, sellerCode, details);
            System.out.println("\nSale completed successfully!");
            System.out.println("Total Amount: $" + sale.calculateTotal());
        } catch (Exception e) {
            System.out.println("Failed to complete sale: " + e.getMessage());
        }
    }

    private void listSales() {
        System.out.println("\n--- Sales History ---");
        List<Sale> sales = saleService.listSales();
        if (sales.isEmpty()) {
            System.out.println("No sales recorded.");
            return;
        }

        for (Sale s : sales) {
            System.out.println("Date: " + s.getDate() + 
                               " | Client: " + s.getClient().getName() + 
                               " | Seller: " + s.getSeller().getName() + 
                               " | Total: $" + s.calculateTotal());
            System.out.println("  Details:");
            for (SaleDetail detail : s.getDetails()) {
                System.out.println("    - " + detail.getProduct().getTitle() + 
                                   " x" + detail.getQuantity() + 
                                   " @ $" + detail.getUnitPrice() + 
                                   " = $" + detail.getSubtotal());
            }
        }
    }

    // Auxiliares de lectura segura de entrada por consola
    private int readInt() {
        try {
            int val = Integer.parseInt(scanner.nextLine().trim());
            return val;
        } catch (NumberFormatException e) {
            System.out.print("Invalid number. Enter again: ");
            return readInt();
        }
    }

    private double readDouble() {
        try {
            double val = Double.parseDouble(scanner.nextLine().trim());
            return val;
        } catch (NumberFormatException e) {
            System.out.print("Invalid price. Enter again: ");
            return readDouble();
        }
    }
}
