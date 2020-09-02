package com.example.checkbox;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox momo,thuppa,chowmin;
    Button buttonOrder;
    TextView total;
    public int totamt = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButtonClick();
    }
    public void addListenerOnButtonClick(){
        momo=(CheckBox)findViewById(R.id.momo);
        chowmin=(CheckBox)findViewById(R.id.chowmin);
        thuppa=(CheckBox)findViewById(R.id.thuppa);
        buttonOrder=(Button)findViewById(R.id.order);
        total=(TextView)findViewById(R.id.total);

        buttonOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StringBuilder result = new StringBuilder();
                result.append("Items Selected:");
                if(momo.isChecked()){
                    result.append("\nMomo Rs. 150");
                    totamt+=150;
                }
                if(chowmin.isChecked()){
                    result.append("\nChowmin Rs. 200");
                    totamt+=200;
                }
                if(thuppa.isChecked()){
                    result.append("\nThuppa Rs. 100");
                    totamt+=100;
                }
                result.append("\nTotal : Rs"+totamt);
                totamt = 0;
                Toast.makeText(getApplicationContext(),result.toString(),Toast.LENGTH_LONG).show();
            }
        });
    }
}