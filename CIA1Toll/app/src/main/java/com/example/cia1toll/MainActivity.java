package com.example.cia1toll;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public int mCount = 0;
    public TextView mShowCount;

    public TextView tShowTotal;
    Button twoW,fourW,tru,vipo,rid;

    public int totalamount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.vehCount);
        tShowTotal = (TextView) findViewById(R.id.totamt);
        twoW=(Button)findViewById(R.id.twoWheel);
        fourW=(Button)findViewById(R.id.fourWheel);
        tru=(Button)findViewById(R.id.truck);
        vipo=(Button)findViewById(R.id.vip);
        rid=(Button)findViewById(R.id.rfid);
        twoW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totalamount = totalamount + 100;
                tShowTotal.setText(Integer.toString(totalamount));
            }
        });
        fourW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totalamount = totalamount + 200;
                tShowTotal.setText(Integer.toString(totalamount));
            }
        });
        tru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totalamount = totalamount + 400;
                tShowTotal.setText(Integer.toString(totalamount));
            }
        });
        vipo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totalamount = totalamount + 0;
                tShowTotal.setText(Integer.toString(totalamount));
            }
        });
        rid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totalamount = totalamount + 50;
                tShowTotal.setText(Integer.toString(totalamount));
            }
        });
    }
    public void countUp(View view) {
        ++mCount;
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
    }
}