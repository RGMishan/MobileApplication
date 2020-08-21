package com.example.wifimanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    SwitchCompat switchCompat;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switchCompat = findViewById(R.id.switch_button);
        imageView = findViewById(R.id.image_view);

        imageView.setImageDrawable(getResources().getDrawable(R.drawable.off));

        switchCompat.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (switchCompat.isChecked()){
                    imageView.setImageDrawable(getResources().getDrawable(R.drawable.blue));
                    WifiManager wifiManager = (WifiManager)getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                    wifiManager.setWifiEnabled(true);

                } else {
                    imageView.setImageDrawable(getResources().getDrawable(R.drawable.off));
                    WifiManager wifiManager = (WifiManager)getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                    wifiManager.setWifiEnabled(false);

                }

            }
        });
    }
}