package com.example.myapplicationlab3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Declaration of View variables/widgets
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btn0;
    private Button btndot;
    private Button btnadd;
    private Button btnsub;
    private Button btndiv;
    private Button btnmul;

    private TextView txtView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //instantiation of view variables
        btn1 =(Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 =(Button) findViewById(R.id.button3);
        btn4 = (Button) findViewById(R.id.button4);
        btn5 =(Button) findViewById(R.id.button5);
        btn6 = (Button) findViewById(R.id.button6);
        btn7 =(Button) findViewById(R.id.button7);
        btn8 = (Button) findViewById(R.id.button8);
        btn9 =(Button) findViewById(R.id.button9);
        btn0 = (Button) findViewById(R.id.button0);
        btndot = (Button) findViewById(R.id.buttondot);
        btnmul = (Button) findViewById(R.id.buttonmult);
        btnadd = (Button) findViewById(R.id.buttonadd);
        btnsub = (Button) findViewById(R.id.buttonsub);
        btndiv = (Button) findViewById(R.id.buttondiv);

        txtView = (TextView) findViewById(R.id.textView2);
        //setting onClickListeners
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtView.append("1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtView.append("2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtView.append("3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtView.append("4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtView.append("5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtView.append("6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtView.append("7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtView.append("8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtView.append("9");
            }
        });
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtView.append("0");
            }
        });
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtView.append("+");
            }
        });
        btnmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtView.append("*");
            }
        });
        btnsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtView.append("-");
            }
        });
        btndiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtView.append("/");
            }
        });
        btndot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtView.append(".");
            }
        });
    }

    public void clickFunction(View view){
        Log.i("info","Button Pressed");
    }
}