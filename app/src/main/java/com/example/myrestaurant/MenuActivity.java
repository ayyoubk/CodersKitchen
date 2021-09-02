package com.example.myrestaurant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myrestaurant.database.AppDB;
import com.example.myrestaurant.database.Dish;

import java.util.List;

public class MenuActivity extends AppCompatActivity {
    AppDB appDB;
    DishAdapter.OnClickDishListener onClickDishListener;
    List<Dish> allDish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        appDB = Room.databaseBuilder(getApplicationContext(), AppDB.class, "dishes").allowMainThreadQueries().build();
        allDish = appDB.dishDao().getAllDishes();
        setOnClickDishListener();
        RecyclerView recyclerView = findViewById(R.id.recycleMenu);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new DishAdapter(allDish,onClickDishListener));

    }
// https://www.youtube.com/watch?v=vBxNDtyE_Co
    private void setOnClickDishListener() {
        onClickDishListener = (view, position) -> {
            Intent intent = new Intent(MenuActivity.this, AboutDishActivity.class);
            System.out.println("00000000000000000000000000000000000000000000000000000");
            intent.putExtra("name", allDish.get(position).dishName);
            intent.putExtra("price", allDish.get(position).price);
            intent.putExtra("ingredients", allDish.get(position).ingredients);
            startActivity(intent);
        };
    }


//    @Override
//    public void dishListener(Dish dish) {
//        Intent intent = new Intent(MenuActivity.this, AboutDishActivity.class);
//        System.out.println("00000000000000000000000000000000000000000000000000000");
//        intent.putExtra("name", dish.dishName);
//        intent.putExtra("price", dish.price);
//        intent.putExtra("ingredients", dish.ingredients);
//        startActivity(intent);
//    }
}