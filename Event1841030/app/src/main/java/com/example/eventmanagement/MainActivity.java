package com.example.eventmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button villa, garden, hill, grand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        villa = (Button) findViewById(R.id.villas);
        garden = (Button) findViewById(R.id.garden);
        hill = (Button) findViewById(R.id.hill);
        grand = (Button) findViewById(R.id.gran);

        hill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });

        garden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog2();
            }
        });

        villa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog3();
            }
        });

        grand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog4();
            }
        });

    }

    public void openDialog() {
        ExampleDialog exampleDialog = new ExampleDialog();
        exampleDialog.show(getSupportFragmentManager(), "example dialog");
    }

    public void openDialog2() {

        ExampleDialog1 exampleDialog = new ExampleDialog1();
        exampleDialog.show(getSupportFragmentManager(), "example dialog");
    }

    public void openDialog3() {
        ExampleDialog2 exampleDialog = new ExampleDialog2();
        exampleDialog.show(getSupportFragmentManager(), "example dialog");
    }

    public void openDialog4() {
        ExampleDialog3 exampleDialog = new ExampleDialog3();
        exampleDialog.show(getSupportFragmentManager(), "example dialog");
    }
}