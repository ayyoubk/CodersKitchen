package com.example.myrestaurant.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Dish.class}, version = 1)
public abstract class AppDB extends RoomDatabase {
    public abstract DishDao dishDao();
}
