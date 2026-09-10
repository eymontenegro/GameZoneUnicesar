
package com.gamezone.service;
 
import com.gamezone.persistence.ProductRepository;
import com.gamezone.model.Product;
import java.util.List;
import com.gamezone.model.VideoGame;
import com.gamezone.model.Console;



public class ProductService {
     private List<Product> products;
     private ProductRepository repository;

    public ProductService() {
        this.repository = new ProductRepository();
        this.products = repository.load();
    }
    
    public void registerVideoGame(String id, String title, double price, int stock, String platform, String genre, String ageRating) {
    VideoGame newVideoGame = new VideoGame( platform, genre, ageRating, id, title, price, stock);
    products.add(newVideoGame);
    repository.save(products); 
}

public void registerConsole(String id, String title, double price, int stock, String brand, String model, String generation) {
    Console newConsole = new Console( brand, model, generation, id, title, price, stock);
    products.add(newConsole);
    repository.save(products);
}
public List<Product> listAll() {
    return products;
}
public void updateStock(String productId, int quantity) {
    for (Product product : products) {
        if (product.getId().equals(productId)) {
            product.reduceStock(quantity);
            repository.save(products);
            return; 
        }
         } 
        throw new IllegalArgumentException("Unknown product id : " + productId);
    }
}

