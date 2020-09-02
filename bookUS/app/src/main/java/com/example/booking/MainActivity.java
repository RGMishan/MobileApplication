package com.example.booking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name,password;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name= (EditText)findViewById(R.id.name);
        password=(EditText)findViewById(R.id.password);
        button=(Button)findViewById(R.id.button);


    }

    public void movepage(View v)
    {
        String stname = name.getText().toString();
        String stpass = password.getText().toString();

        if (stname.equals("mishanregmi") && stpass.equals("password"))
        {
            Intent in = new Intent(MainActivity.this, Main2Activity.class);
            startActivity(in);

        }

        else if (stname.equals("") || stpass.equals(""))
        {
            Toast.makeText(getBaseContext(),"Field Empty Enter Valid Input",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getBaseContext(),"Password or ID Mismatched",Toast.LENGTH_SHORT).show();
        }

    }
}
