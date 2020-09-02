package com.example.lab_5_order;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class order extends AppCompatActivity {
    private Button cancel;
    private Button order;
    private TextView amt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order);
        ArrayList<String> food=getIntent().getStringArrayListExtra("food");
        ArrayList<Integer> price=getIntent().getIntegerArrayListExtra("price");
        Integer Total=getIntent().getIntExtra("Total",0);
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,R.layout.hello,food);
        ArrayAdapter<Integer> adapter1=new ArrayAdapter<>(this,R.layout.price,price);
        ListView food_list=(ListView)findViewById(R.id.food_list);
        food_list.setAdapter(adapter);
        ListView price_list=(ListView)findViewById(R.id.price_list);
        price_list.setAdapter(adapter1);
        amt=(TextView)findViewById(R.id.amt);
        amt.setText("Rs."+Total.toString());
        addOnclickListner();

    }

    public void addOnclickListner() {
        cancel = (Button) findViewById(R.id.cancel);
        order = (Button) findViewById(R.id.order);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent previous = new Intent(order.this, MainActivity.class);
                startActivity(previous);
            }
        });
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast t=Toast.makeText(getApplicationContext(),"Order Placed",Toast.LENGTH_LONG);
                t.show();

            }
        });


    }
}
