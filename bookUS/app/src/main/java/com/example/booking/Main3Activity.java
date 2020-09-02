package com.example.booking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ArrayList<String> fin= getIntent().getStringArrayListExtra("book");
        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.list, fin);
        ListView list_booked =(ListView)findViewById(R.id.list_booked);
        list_booked.setAdapter(adapter);

    }
}
