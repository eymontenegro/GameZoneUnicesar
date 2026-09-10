
package com.gamezone.model;


public class Console extends Product {
    private String brand;
    private String model;
    private String generation;

    public Console(String brand, String model, String generation, String id, String title, double price, int stock) {
        super(id, title, price, stock);
        this.brand = brand;
        this.model = model;
        this.generation = generation;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getGeneration() {
        return generation;
    }

    @Override
    public String describe() {
        return   getTitle()+ " is a console by " + brand + " , model " + model + " , generation " + generation ;   }
 
    
    
    
}
