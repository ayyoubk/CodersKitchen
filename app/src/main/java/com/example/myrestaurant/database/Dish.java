package com.example.myrestaurant.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Dish {
    @PrimaryKey(autoGenerate = true)
    public int dishId;
    public String dishName;
    public String price;
    public String ingredients;

    public Dish(String dishName, String price, String ingredients) {
        this.dishName = dishName;
        this.price = price;
        this.ingredients = ingredients;
    }
}
