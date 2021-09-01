package com.example.myrestaurant.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DishDao {

    @Query("SELECT * FROM dish")
    List<Dish> getAllDishes();

    @Insert
    void insertAll(Dish... dishes);
}
