
package com.gamezone.model;

public class VideoGame extends Product {
    private String platform;
    private String genre;
    private String ageRating;

    public VideoGame(String platform, String genre, String ageRating, String id, String title, double price, int stock) {
        super(id, title, price, stock);
        this.platform = platform;
        this.genre = genre;
        this.ageRating = ageRating;
    }

    public String getPlatform() {
        return platform;
    }

    public String getGenre() {
        return genre;
    }

    public String getAgeRating() {
        return ageRating;
    }
     
    
    @Override
public String describe() {
    return getTitle() + " es un videojuego para " + platform + " de " + genre + " clasificado para " + ageRating ; 
}
}
