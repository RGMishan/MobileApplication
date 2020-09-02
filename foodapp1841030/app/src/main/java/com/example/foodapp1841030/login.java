package com.example.foodapp1841030;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {

    private ImageButton submit;
    private EditText email;
    private EditText password;
    private ImageButton toggle;
    private Boolean showpass=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        submit=(ImageButton)findViewById(R.id.submit);
        email=(EditText)findViewById(R.id.email);
        password=(EditText)findViewById(R.id.password);
        toggle=(ImageButton)findViewById(R.id.toggle);
        final String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";


        toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(showpass==false){
                    password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    password.setSelection(password.getText().length());
                    showpass=true;
                }
                else{
                    password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    password.setSelection(password.getText().length());
                    showpass=false;
                }
            }
        });
        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String e=email.getText().toString().trim();
                String P=password.getText().toString();

                if(e.isEmpty() || P.isEmpty())
                {
                    Toast.makeText(login.this,"Input Required in both the fields",Toast.LENGTH_LONG).show();
                }
                else if(!e.matches(emailPattern)){
                    Toast.makeText(login.this,"Invalid Email",Toast.LENGTH_LONG).show();
                    email.setText("");
                    password.setText("");
                }
                else if(e.matches("aastha@gmail.com")&&P.matches("12345")){
                    Intent function = new Intent(login.this, MainActivity.class);
                    function.putExtra("Username","Aastha Narang");
                    startActivity(function);
                }
                else if(e.matches("maam@gmail.com")&&P.matches("maam")){
                    Intent function = new Intent(login.this, MainActivity.class);
                    function.putExtra("Username","Madam");
                    startActivity(function);
                }
                else{
                    Toast.makeText(login.this,"User does not exist",Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
