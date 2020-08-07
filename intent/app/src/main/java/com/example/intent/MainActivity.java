package com.example.intent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

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

        if (stname.equals("Aastha") && stpass.equals("12345678"))
        {
            Intent in = new Intent(MainActivity.this, Main3Activity.class);
            startActivity(in);

        }

        else if (stname.equals("") || stpass.equals(""))
        {
            Toast.makeText(getBaseContext(),"Enter Username and password",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getBaseContext(),"Wrong Username and Password",Toast.LENGTH_SHORT).show();
        }

    }
}
