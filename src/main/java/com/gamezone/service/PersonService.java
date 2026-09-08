package com.gamezone.service;

import com.gamezone.model.Client;
import com.gamezone.model.Seller;
import com.gamezone.persistence.PersonRepository;
import java.util.List;

/**
 * Provides business logic for managing clients and sellers.
 * This class is the only one in the module authorized to
 * communicate with the persistence layer.
 */
public class PersonService {

    private PersonRepository repository;
    private List<Client> clients;
    private List<Seller> sellers;

    /**
     * Creates a new PersonService and loads the existing
     * clients and sellers from persistent storage.
     */
    public PersonService() {
        this.repository = new PersonRepository();
        this.clients = repository.loadClients();
        this.sellers = repository.loadSellers();
    }

    /**
     * Registers a new client and saves the updated list to storage.
     *
     * @param name the full name of the client
     * @param identification the identification number of the client
     * @param phone the contact phone number of the client
     * @param email the email address of the client
     */
    public void registerClient(String name, String identification, String phone, String email) {
        Client client = new Client(name, identification, phone, email);
        clients.add(client);
        repository.saveClients(clients);
    }

    /**
     * Returns the list of all registered clients.
     *
     * @return the list of clients
     */
    public List<Client> listClients() {
        return clients;
    }

    /**
     * Returns the list of all registered sellers.
     * Sellers are preloaded and not registered through the user interface.
     *
     * @return the list of sellers
     */
    public List<Seller> listSellers() {
        return sellers;
    }
}