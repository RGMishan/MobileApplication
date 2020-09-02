package com.example.lab_5_order;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import static android.app.PendingIntent.getActivity;

public class MainActivity extends AppCompatActivity {


    private ImageView imageView3;
    private RadioGroup rg;
    private RadioButton r1,veg,n_veg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButtonClick();
    }

    public void addListenerOnButtonClick(){

        rg=(RadioGroup)findViewById(R.id.cuisine);
        imageView3=(ImageView) findViewById(R.id.imageView3);
        veg=(RadioButton)findViewById(R.id.Veg);
        n_veg=(RadioButton)findViewById(R.id.Non_veg);
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selected_id=rg.getCheckedRadioButtonId();
                r1=(RadioButton)findViewById(selected_id);

                if(r1==veg){
                    Intent newscreen = new Intent(MainActivity.this, Veg_list.class);
                    startActivity(newscreen);
                }
                else if(r1==n_veg){
                    Intent newscreen = new Intent(MainActivity.this, non_veg_list.class);
                    startActivity(newscreen);
                }
            }
        });


    }

    }

