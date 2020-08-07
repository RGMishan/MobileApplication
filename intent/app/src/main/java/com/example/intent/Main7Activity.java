package com.example.intent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Main7Activity extends AppCompatActivity {
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        btn = (Button) findViewById(R.id.idbtn);
    }
    public void btnClick(View view){
        Uri uri = Uri.parse("geo:0,0?q=Christ university, Hosur+Road, Bangalore");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, uri);
        Intent chooser = Intent.createChooser(mapIntent, "Launch Maps");
        startActivity(chooser);
    }
}