package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main4Activity extends AppCompatActivity {

    private EditText edit_to,edit_sub,edit_msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        edit_to=findViewById(R.id.Edit_to);
        edit_sub=findViewById(R.id.Edit_sub);
        edit_msg=findViewById(R.id.Edit_msg);
        Button btnSend = findViewById(R.id.Edit_send);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 sendMail();
            }
        });

    }

    private void sendMail(){
        String list = edit_to.getText().toString();
        String[] r_list = list.split(",");
        String subject = edit_sub.getText().toString();
        String msg = edit_msg.getText().toString();

        Intent intent= new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL,r_list);
        intent.putExtra(Intent.EXTRA_SUBJECT,subject);
        intent.putExtra(Intent.EXTRA_TEXT,msg);
        intent.setType("msg/rfc822");
        startActivity(Intent.createChooser(intent,"Choose an email client"));
    }
}
