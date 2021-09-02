package com.example.myrestaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class AboutDishActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_dish);

        Intent intent = getIntent();
        String name = intent.getExtras().getString("name");
        TextView dishTitle = findViewById(R.id.dishTitle);
        dishTitle.setText(name);

        String price = intent.getExtras().getString("price");
        TextView dishPrice = findViewById(R.id.priceText);
        dishPrice.setText("Price: "+price+" $");

        String ingredients = intent.getExtras().getString("ingredients");
        TextView dishIngredients = findViewById(R.id.ingredinteText);
        dishIngredients.setText(ingredients);
    }
}