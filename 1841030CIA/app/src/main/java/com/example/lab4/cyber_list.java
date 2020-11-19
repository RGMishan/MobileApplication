package com.example.lab4;



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

public class cyber_list extends AppCompatActivity {
    private ImageView imageView4;
    private ImageView imageView3;
    private CheckBox name1,name2,name3,date1,date2,date3,option1,option2,option3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.python_item);
        addOnclickListner();
    }
    public void addOnclickListner(){
        imageView4=(ImageView)findViewById(R.id.imageView4);
        imageView3=(ImageView)findViewById(R.id.imageView3);
        name1=(CheckBox)findViewById(R.id.name1);
        name2=(CheckBox)findViewById(R.id.name2);
        name3=(CheckBox)findViewById(R.id.name3);
        date1=(CheckBox)findViewById(R.id.date1);
        date2=(CheckBox)findViewById(R.id.date2);
        date3=(CheckBox)findViewById(R.id.date3);
        option1=(CheckBox)findViewById(R.id.option1);
        option2=(CheckBox)findViewById(R.id.option2);
        option3=(CheckBox)findViewById(R.id.option3);
        final ArrayList<String> food=new ArrayList<String>();
        final ArrayList<Integer> price=new ArrayList<Integer>();

        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent previous=new Intent(cyber_list.this,order.class);
                startActivity(previous);
            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int total=0;

                if(name1.isChecked()) {
                    total += 1;

                }
                if(name2.isChecked()) {
                    total += 1;

                }if(name3.isChecked()) {
                    total += 1;

                }

                    if(date1.isChecked()) {
                        total += 1;

                    }
                    if(date2.isChecked()) {
                        total += 1;

                    }if(date3.isChecked()) {
                        total += 1;

                    }


                        if(option1.isChecked()) {
                            total += 1;

                        }
                        if(option2.isChecked()) {
                            total += 1;

                        }if(option3.isChecked()) {
                            total += 1;

                        }
                        Intent order=new Intent(cyber_list.this, com.example.lab4.order.class);

                        order.putExtra("Total",total);
                        startActivity(order);

                    }

                });



            }
        }
