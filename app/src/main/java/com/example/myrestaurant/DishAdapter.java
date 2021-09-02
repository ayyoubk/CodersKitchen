package com.example.myrestaurant;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myrestaurant.database.Dish;

import java.util.List;

public class DishAdapter extends RecyclerView.Adapter<DishAdapter.DishViewHolder> {

    public interface OnClickDishListener {
        void dishListener(View view, int position);
    }

    public List<Dish> allDish;
    static OnClickDishListener onClickDishListener;

    public DishAdapter(List<Dish> allDish, OnClickDishListener onClickDishListener) {
        this.allDish = allDish;
        this.onClickDishListener=onClickDishListener;
    }

    public static class DishViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        Dish dish;
        View itemView;

        public DishViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onClickDishListener.dishListener(view,getAdapterPosition());
        }
    }

    @NonNull
    @Override
    public DishViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_dish, parent, false);
        DishViewHolder dishViewHolder = new DishViewHolder(view);
        return dishViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DishViewHolder holder, int position) {
        holder.dish = allDish.get(position);
        TextView taskTitle = holder.itemView.findViewById(R.id.dishInfo);
        taskTitle.setText(holder.dish.dishName + " Price: " + holder.dish.price + "$");
    }

    @Override
    public int getItemCount() {
        return allDish.size();
    }
}
