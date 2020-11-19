package com.example.lab4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {


    private ImageView imageView3;
    private RadioGroup rg;
    private RadioButton r1,python,ma,cyber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButtonClick();
    }

    public void addListenerOnButtonClick(){

        rg=(RadioGroup)findViewById(R.id.subjects);
        imageView3=(ImageView) findViewById(R.id.imageView3);
        python=(RadioButton)findViewById(R.id.python);
        ma=(RadioButton)findViewById(R.id.ma);
        cyber=(RadioButton)findViewById(R.id.cyber);
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selected_id=rg.getCheckedRadioButtonId();
                r1=(RadioButton)findViewById(selected_id);

                if(r1==python){
                    Intent newscreen = new Intent(MainActivity.this, python_list.class);
                    startActivity(newscreen);
                }
                else if(r1==ma){
                    Intent newscreen = new Intent(MainActivity.this, ma_list.class);
                    startActivity(newscreen);
                }
                else if(r1==cyber){
                    Intent newscreen = new Intent(MainActivity.this, cyber_list.class);
                    startActivity(newscreen);
                }

            }
        });


    }

}

