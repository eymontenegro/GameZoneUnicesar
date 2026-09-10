
package com.gamezone.persistence;

import com.gamezone.model.Product;
import com.gamezone.model.VideoGame;
import com.gamezone.model.Console;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


    
    
public class ProductRepository {
    
    
    private String productToCsvLine(Product product){
        String commonData = product.getId() + "," + product.getTitle() + "," + product.getPrice() + "," + product.getStock();
        
        String type;
        String specificData;
        
        if (product instanceof VideoGame){
            VideoGame vg = (VideoGame) product;
            type = "VIDEOGAME";
            specificData = vg.getPlatform() + "," + vg.getGenre() + "," + vg.getAgeRating();
            
        }else if (product instanceof Console){
            Console c =(Console) product;
            type = "CONSOLE";
            specificData = c.getBrand() + "," + c.getModel() + "," + c.getGeneration();
        } else {
            throw new IllegalArgumentException("Unknown product type");
}   

        return type + "," + commonData + "," + specificData;
    
    }
    
    
    public void save(List<Product> products) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("data/products.csv"))) {
        for (Product product : products) {
            writer.write(productToCsvLine(product));
            writer.newLine();
        }
    } catch (IOException e) {
        
      throw new RuntimeException("Error saving products: " + e.getMessage(), e);
    }
}
}

  


