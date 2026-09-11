package com.gamezone.persistence;

import com.gamezone.model.Client;
import com.gamezone.model.Seller;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Handles the persistence of Client and Seller data using CSV files.
 * This class is responsible for saving and loading person information
 * to and from the file system.
 */
public class PersonRepository {

    private static final String CLIENTS_FILE = "data/clients.csv";
    private static final String SELLERS_FILE = "data/sellers.csv";

    /**
     * Saves the given list of clients to the clients CSV file.
     *
     * @param clients the list of clients to save
     */
    public void saveClients(List<Client> clients) {
        try (FileWriter writer = new FileWriter(CLIENTS_FILE)) {
            for (Client client : clients) {
                writer.write(client.getName() + "," 
                        + client.getIdentification() + "," 
                        + client.getPhone() + "," 
                        + client.getEmail() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error saving clients: " + e.getMessage());
        }
    }

    /**
     * Loads the list of clients from the clients CSV file.
     *
     * @return the list of clients loaded from the file
     */
    public List<Client> loadClients() {
        List<Client> clients = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(CLIENTS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    clients.add(new Client(parts[0], parts[1], parts[2], parts[3]));
                }
            }
        } catch (IOException e) {
            System.out.println("No previous client data found. Starting empty.");
        }
        return clients;
    }

    /**
     * Saves the given list of sellers to the sellers CSV file.
     *
     * @param sellers the list of sellers to save
     */
    public void saveSellers(List<Seller> sellers) {
        try (FileWriter writer = new FileWriter(SELLERS_FILE)) {
            for (Seller seller : sellers) {
                writer.write(seller.getName() + "," 
                        + seller.getIdentification() + "," 
                        + seller.getPhone() + "," 
                        + seller.getEmployeeCode() + "," 
                        + seller.getShift() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error saving sellers: " + e.getMessage());
        }
    }

    /**
     * Loads the list of sellers from the sellers CSV file.
     *
     * @return the list of sellers loaded from the file
     */
    public List<Seller> loadSellers() {
        List<Seller> sellers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(SELLERS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    sellers.add(new Seller(parts[0], parts[1], parts[2], parts[3], parts[4]));
                }
            }
        } catch (IOException e) {
            System.out.println("No previous seller data found. Starting empty.");
        }
        return sellers;
    }
}