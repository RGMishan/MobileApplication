package com.example.lab_5_order;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class non_veg_list extends AppCompatActivity {

    private Button back;
    private Button next;
    private CheckBox pizza,burger,ff,chicken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.non_veg_item);
        addOnclickListener();
    }

    public void addOnclickListener(){
        back=(Button)findViewById(R.id.back);
        next=(Button)findViewById(R.id.next);
        pizza=(CheckBox)findViewById(R.id.chicken_pizza);
        burger=(CheckBox)findViewById(R.id.lamb_burger);
        chicken=(CheckBox)findViewById(R.id.chicken);
        final ArrayList<String> food=new ArrayList<String>();
        final ArrayList<Integer> price=new ArrayList<Integer>();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent previous=new Intent(non_veg_list.this,MainActivity.class);
                startActivity(previous);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int total=0;

                if(chicken.isChecked()) {
                    total += 400;
                    food.add("Fish");
                    price.add(400);
                }
                if(burger.isChecked()) {
                    total += 150;
                    food.add("Chicken Tandoori");
                    price.add(150);
                }if(ff.isChecked()) {
                    total += 100;
                    food.add("MomMo");
                    price.add(100);
                }if(pizza.isChecked()) {
                    total += 300;
                    food.add("Food");
                    price.add(300);
                }
                Intent order=new Intent(non_veg_list.this, com.example.lab_5_order.order.class);
                order.putStringArrayListExtra("food",food);
                order.putIntegerArrayListExtra("price",price);
                order.putExtra("Total",total);
                startActivity(order);
            }
        });



    }
}
