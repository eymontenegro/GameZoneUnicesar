package com.gamezone.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a client of the store.
 * A client is a specialization of Person that keeps
 * track of an email address and a purchase history.
 */
public class Client extends Person {

    private String email;
    private List<Sale> purchaseHistory;

    /**
     * Creates a new Client with the given basic information and email.
     *
     * @param name the full name of the client
     * @param identification the identification number of the client
     * @param phone the contact phone number of the client
     * @param email the email address of the client
     */
    public Client(String name, String identification, String phone, String email) {
        super(name, identification, phone);
        this.email = email;
        this.purchaseHistory = new ArrayList<>();
    }

    /**
     * Returns the email address of the client.
     *
     * @return the client's email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Returns the purchase history of the client.
     *
     * @return the list of sales made by the client
     */
    public List<Sale> getPurchaseHistory() {
        return purchaseHistory;
    }

    /**
     * Adds a sale to the client's purchase history.
     *
     * @param sale the sale to add
     */
    public void addSale(Sale sale) {
        purchaseHistory.add(sale);
    }

    /**
     * Returns a description of the client that includes
     * the email address and the number of purchases made.
     *
     * @return a description of the client
     */
    @Override
    public String getDescription() {
        return "Client: " + getName() + " | Email: " + email +
               " | Purchases made: " + purchaseHistory.size();
    }
}