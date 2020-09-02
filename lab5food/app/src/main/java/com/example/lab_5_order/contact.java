package com.example.lab_5_order;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class contact extends AppCompatActivity {
    Button btnMail;
    Button webBtn;
    Button btnMap;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contactus);
        btnMail = (Button) findViewById(R.id.mailBtn);
        btnMap = (Button) findViewById(R.id.mapBtn);
        webBtn = (Button) findViewById(R.id.webBtn);
        button = (Button) findViewById(R.id.button);

        webBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse("www.foodmandu.com")) ;
                Intent chooser = Intent.createChooser(intent, "Choose a  browser");
                startActivity(chooser);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("tel: +916362136158"));
                Intent chooser = Intent.createChooser(intent, "Choose the app to call");
                startActivity(chooser);
            }
        });

        btnMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SEND).setData(Uri.parse("email"));
                String[] s = {"abc@gmail.com","xyz@gmail.com"};
                i.putExtra(Intent.EXTRA_EMAIL, s);
                i.putExtra(Intent.EXTRA_SUBJECT,"Help Needed");
                i.putExtra(Intent.EXTRA_TEXT, "Hey I need some help with my order. ...");
                i.setType("message / rfc822"); //setting MIME Email Multipurpose Internet Mail Extensions
                Intent chooser = Intent.createChooser(i,"Launch Email");
                startActivity(chooser);
            }
        });
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("geo: 12.972442, 77.5806438"));
                Intent chooser = Intent.createChooser(i,"Launch Maps");
                startActivity(chooser); // select the app in your phone to open the location ex: google map, uber, ola ….etc
            }
        });

    }
}