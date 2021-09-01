package com.example.myrestaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addDishButton = findViewById(R.id.addDishBtn);
        addDishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toAddActivity = new Intent(MainActivity.this, AddDishActivity.class);
                startActivity(toAddActivity);
            }
        });

        Button menuButton = findViewById(R.id.menuBtn);
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toAddActivity = new Intent(MainActivity.this, MenuActivity.class);
                startActivity(toAddActivity);
            }
        });
    }
}