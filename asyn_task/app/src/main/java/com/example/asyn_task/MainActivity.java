package com.example.asyn_task;

import androidx.appcompat.app.AppCompatActivity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    BroadcastReceiver broadcastReceiver;
    TextView textView;
    View view;
    boolean Microphone_Plugged_in = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view=this.getWindow().getDecorView();
        view.setBackgroundResource(R.color.white);
        textView = findViewById(R.id.text);
        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                final String action = intent.getAction();
                int iii;
                if (Intent.ACTION_HEADSET_PLUG.equals(action)) {
                    iii = intent.getIntExtra("state", -1);
                    if (iii == 0) {
                        Microphone_Plugged_in = false;
                        Toast.makeText(getApplicationContext(), "Headphone Not Connected", Toast.LENGTH_LONG).show();
                    }
                    if (iii == 1) {
                        Microphone_Plugged_in = true;
                        Toast.makeText(getApplicationContext(), "Headphone Connected",
                                Toast.LENGTH_LONG).show();
                    }
                }
            }
        };
        IntentFilter receiverFilter = new IntentFilter(Intent.ACTION_HEADSET_PLUG);
        registerReceiver(broadcastReceiver, receiverFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        MainActivity.this.unregisterReceiver(mMessageReceiver);
    }
    @Override
    protected void onResume() {
        super.onResume();
        MainActivity.this.registerReceiver(mMessageReceiver, new    IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED));
    }
    private BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            textView.setText("Aeroplane Mode ON");
        }
    };

}
