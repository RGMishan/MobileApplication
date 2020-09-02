package com.example.booking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
     CheckBox venue,hotel;
     ImageView now;
     final ArrayList<String> book= new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        venue=(CheckBox) findViewById(R.id.venue);
        hotel=(CheckBox) findViewById(R.id.hotel);
        now=(ImageView)findViewById((R.id.now));

        now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (venue.isChecked())
                {
                    book.add("Audi Venue Booked");
                }
                if (hotel.isChecked())
                {
                    book.add("Taj Hotel");
                }
                Intent in = new Intent(Main2Activity.this,Main3Activity.class);
                in.putStringArrayListExtra("book",book);
                startActivity(in);
            }
        });


    }
}
