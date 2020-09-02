package com.example.lab_5_order;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class both extends AppCompatActivity {
    private Button back;
    private Button next;
    private CheckBox vpizza,vburger,vff,chicken,npizza,nburger,coffee,nff;
    private ArrayList<String> food;
    private ArrayList<Integer> price;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.both_item);
        addOnclickListner();

    }
    public void addOnclickListner(){
        back=(Button)findViewById(R.id.back);
        next=(Button)findViewById(R.id.next);
        vpizza=(CheckBox)findViewById(R.id.mush_pizza);
        vburger=(CheckBox)findViewById(R.id.paneer_burger);
        vff=(CheckBox)findViewById(R.id.vfries);
        chicken=(CheckBox)findViewById(R.id.r_chicken);
        npizza=(CheckBox)findViewById(R.id.npizza);
        nburger=(CheckBox)findViewById(R.id.nburger);
        coffee=(CheckBox)findViewById(R.id.cofe);
        food=new ArrayList<String>();
        price=new ArrayList<Integer>();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent previous=new Intent(both.this,MainActivity.class);
                startActivity(previous);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int total=0;
//
                if(chicken.isChecked()) {
                    total += 400;
                    food.add("Roasted Chicken");
                    price.add(400);
                }
                if(vburger.isChecked()) {
                    total += 100;
                    food.add("Paneer Burger");
                    price.add(100);
                }if(vff.isChecked()) {
                    total +=80;
                    food.add("French Fries");
                    price.add(80);
                }if(vpizza.isChecked()) {
                    total += 200;
                    food.add("Mushroom Pizza");
                    price.add(200);
                }
                if(nburger.isChecked()) {
                    total += 150;
                    food.add("Lamb Burger");
                    price.add(150);
                }if(coffee.isChecked()) {
                    total += 70;
                    food.add("Coffee");
                    price.add(70);
                }if(npizza.isChecked()) {
                    total += 300;
                    food.add("Chicken Pizza");
                    price.add(300);
                }
                Intent order=new Intent(both.this, order.class);
                order.putStringArrayListExtra("food",food);
                order.putIntegerArrayListExtra("price",price);
                order.putExtra("Total",total);
                startActivity(order);

            }
        });



    }
}
