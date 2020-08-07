package com.example.intent;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class Main5Activity extends AppCompatActivity {
    EditText num;
    ImageButton btn_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        num= findViewById(R.id.num);
        btn_img= findViewById(R.id.btn_img);

        btn_img.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("MissingPermission")
            @Override
            public void onClick(View v) {
                String phone = num.getText().toString();
                Intent intent= new Intent(Intent.ACTION_CALL);
                if (phone.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Please Enter Number",Toast.LENGTH_SHORT).show();

                }
                else {
                    String s = "tel: " + phone;
                    intent.setData(Uri.parse(s));

                }
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(Main5Activity.this,"please Grant Permission", Toast.LENGTH_SHORT).show();
                    requestionPermission();

                }
                else {
                    startActivity(intent);
                }
            }

        });
    }
    private void requestionPermission(){
        ActivityCompat.requestPermissions( Main5Activity.this,new String[]{Manifest.permission.CALL_PHONE},1);

    }
}
