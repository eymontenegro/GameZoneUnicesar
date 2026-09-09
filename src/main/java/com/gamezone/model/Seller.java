package com.gamezone.model;

/**
 * Represents a seller (employee) of the store.
 * A seller is a specialization of Person that keeps
 * track of an employee code and an assigned work shift.
 */
public class Seller extends Person {

    private String employeeCode;
    private String shift;

    /**
     * Creates a new Seller with the given basic information,
     * employee code and work shift.
     *
     * @param name the full name of the seller
     * @param identification the identification number of the seller
     * @param phone the contact phone number of the seller
     * @param employeeCode the employee code assigned to the seller
     * @param shift the work shift assigned to the seller
     */
    public Seller(String name, String identification, String phone, String employeeCode, String shift) {
        super(name, identification, phone);
        this.employeeCode = employeeCode;
        this.shift = shift;
    }

    /**
     * Returns the employee code of the seller.
     *
     * @return the seller's employee code
     */
    public String getEmployeeCode() {
        return employeeCode;
    }

    /**
     * Returns the work shift assigned to the seller.
     *
     * @return the seller's work shift
     */
    public String getShift() {
        return shift;
    }

    /**
     * Returns a description of the seller that includes
     * the employee code and the assigned work shift.
     *
     * @return a description of the seller
     */
    @Override
    public String getDescription() {
        return "Seller: " + getName() + " | Employee Code: " + employeeCode +
               " | Shift: " + shift;
    }
}