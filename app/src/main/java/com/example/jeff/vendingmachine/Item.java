package com.example.jeff.vendingmachine;

/**
 * Created by jefff on 2/24/2018.
 */

public class Item {
    public String name;
    public double price;
    public int stock;
    public String pathToImage;
    public int calories;

    Item(String name, double price, int stock, String pathToImage, int calories) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.pathToImage = pathToImage;
        this.calories = calories;
    }

    Item(String name, double price, int stock, String pathToImage) {
        this(name, price, stock, pathToImage, 0);
    }

    Item(String name, double price, int stock) {
        this(name, price, stock, "", 0);
    }

    public static final int LAYS_CLAS = 0;
    public static final int LAYS_SOUR = 1;
    public static final int DOR_COOL = 2;
    public static final int DOR_NACH = 3;
    public static final int DOR_SPICY = 4;
    public static final int TAKI_FUE = 5;
    public static final int BROCOLLI = 6;
    public static final int APPLE = 7;
    public static final int NIS_CHICK = 8;
    public static final int FIVE_HOUR = 9;
}
