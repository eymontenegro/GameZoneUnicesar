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

    /**
     * Sets the name of the person.
     *
     * @param name the new name of the person
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the identification of the person.
     *
     * @param identification the new identification of the person
     */
    public void setIdentification(String identification) {
        this.identification = identification;
    }

    /**
     * Sets the contact phone number of the person.
     *
     * @param phone the new phone number of the person
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Returns a description of the person that integrates
     * the particular characteristics of its specific role.
     * Must be implemented by every concrete subclass.
     *
     * @return a description specific to the type of person
     */
    public abstract String getDescription();
}