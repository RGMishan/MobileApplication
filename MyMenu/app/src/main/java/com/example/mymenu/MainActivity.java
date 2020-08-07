package com.example.mymenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    public ImageView img ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = (ImageView) findViewById(R.id.img);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // two parameter - 1 which xml file , menu class name
        getMenuInflater().inflate(R.menu.mymenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case R.id.it1:
                Toast.makeText(this, "OPEN", Toast.LENGTH_SHORT).show();
                img.setImageResource(R.drawable.open);
                return true;
            case R.id.it2:
                Toast.makeText(this, "close", Toast.LENGTH_SHORT).show();
                finish();
                System.exit(0);
                return true;
            case R.id.it3:
                Toast.makeText(this, "save", Toast.LENGTH_SHORT).show();
                img.setImageResource(R.drawable.save);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
