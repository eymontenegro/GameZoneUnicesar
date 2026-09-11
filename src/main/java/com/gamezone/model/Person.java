package com.gamezone.model;

/**
 * Represents a generic person that interacts with the store.
 * This class is abstract because a person must always be
 * specialized as a Client or a Seller.
 */
public abstract class Person {

    private String name;
    private String identification;
    private String phone;

    /**
     * Creates a new Person with the given basic information.
     *
     * @param name the full name of the person
     * @param identification the identification number of the person
     * @param phone the contact phone number of the person
     */
    public Person(String name, String identification, String phone) {
        this.name = name;
        this.identification = identification;
        this.phone = phone;
    }

    /**
     * Returns the name of the person.
     *
     * @return the person's name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the identification of the person.
     *
     * @return the person's identification
     */
    public String getIdentification() {
        return identification;
    }

    /**
     * Returns the contact phone number of the person.
     *
     * @return the person's phone number
     */
    public String getPhone() {
        return phone;
    }
}