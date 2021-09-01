package com.example.myrestaurant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myrestaurant.database.AppDB;
import com.example.myrestaurant.database.Dish;
import com.example.myrestaurant.database.DishDao;

public class AddDishActivity extends AppCompatActivity {
    AppDB appDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dish);
        EditText dishName= findViewById(R.id.dishNameInput);
        EditText dishPrice= findViewById(R.id.dishPriceInput);
        EditText dishIngredients= findViewById(R.id.ingredientInput);

        Button submitUserName = findViewById(R.id.submitDish);
        submitUserName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create New Dish
                Dish newDish = new Dish(dishName.getText().toString(),dishPrice.getText().toString(),dishIngredients.getText().toString());
                // Save It To DB
                appDB= Room.databaseBuilder(getApplicationContext(),AppDB.class,"dishes").allowMainThreadQueries().build();
                DishDao dishDao = appDB.dishDao();
                dishDao.insertAll(newDish);
                Toast.makeText(getApplicationContext(), "Dish Added!", Toast.LENGTH_SHORT).show();
                Intent goToHome = new Intent(AddDishActivity.this, MainActivity.class);
                startActivity(goToHome);
            }
        });
    }
}