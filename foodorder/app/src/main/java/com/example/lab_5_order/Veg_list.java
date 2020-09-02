package com.example.lab_5_order;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Veg_list extends AppCompatActivity {
    private ImageView imageView4;
    private ImageView imageView3;
    private CheckBox pizza,burger,ff,coffee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.veg_item);
        addOnclickListner();
    }
    public void addOnclickListner(){
        imageView4=(ImageView)findViewById(R.id.imageView4);
        imageView3=(ImageView)findViewById(R.id.imageView3);
        pizza=(CheckBox)findViewById(R.id.veg_pizza);
        burger=(CheckBox)findViewById(R.id.veg_burger);
        ff=(CheckBox)findViewById(R.id.ff);
        coffee=(CheckBox)findViewById(R.id.drink);
        final ArrayList<String> food=new ArrayList<String>();
        final ArrayList<Integer> price=new ArrayList<Integer>();

        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent previous=new Intent(Veg_list.this,MainActivity.class);
                startActivity(previous);
            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int total=0;

                if(pizza.isChecked()) {
                    total += 200;
                    food.add("Mushroom Pizza");
                    price.add(200);
                }
                if(burger.isChecked()) {
                    total += 100;
                    food.add("Paneer Burger");
                    price.add(100);
                }if(ff.isChecked()) {
                    total += 70;
                    food.add("French Fries");
                    price.add(70);
                }if(coffee.isChecked()) {
                    total += 80;
                    food.add("Coffee");
                    price.add(80);
                }
                Intent order=new Intent(Veg_list.this, com.example.lab_5_order.order.class);
                order.putStringArrayListExtra("food",food);
                order.putIntegerArrayListExtra("price",price);
                order.putExtra("Total",total);
                startActivity(order);

                }

        });



    }
}
