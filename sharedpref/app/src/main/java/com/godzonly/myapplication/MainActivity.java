package com.godzonly.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private EditText editName;
    private EditText editAddress;
    private EditText editPhone;
    private EditText editEmail;

    private RadioGroup PartOfDay;
    private RadioButton rdbMorning;
    private RadioButton rdbAfternoon;
    private RadioButton rdbEvening;
    private RadioButton rdbNight;

    public static final String MYPREFS = "mySharedPreferences";
    private String favouritePartOfDay;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = (EditText)findViewById(R.id.EditTextName);
        editAddress = (EditText)findViewById(R.id.EditTextAddress);
        editPhone = (EditText)findViewById(R.id.EditTextPhone);
        editEmail = (EditText)findViewById(R.id.EditTextEmail);
        PartOfDay = (RadioGroup)findViewById(R.id.rdoFavouritePart);
        rdbMorning = (RadioButton) findViewById(R.id.Morning);
        rdbAfternoon = (RadioButton)findViewById(R.id.Afternoon);
        rdbEvening = (RadioButton)findViewById(R.id.Evening);
        rdbNight = (RadioButton)findViewById(R.id.Night);

        this.loadPreferences();
    }

    public void loadPreferences(){
        int mode = Activity.MODE_PRIVATE;
        android.content.SharedPreferences mySharedPreferences = getSharedPreferences(MYPREFS, mode);
        editName.setText(mySharedPreferences.getString("Name",""));
        editAddress.setText(mySharedPreferences.getString("Address",""));
        editPhone.setText(mySharedPreferences.getString("Phone",""));
        editEmail.setText(mySharedPreferences.getString("Email",""));
        favouritePartOfDay = mySharedPreferences.getString("favouritePartOfDay","");
        loadRadioButtonPreferences();
    }
    public void loadRadioButtonPreferences(){
        switch (favouritePartOfDay) {
            case "m":
                PartOfDay.check(R.id.Morning);
                break;
            case "a":
                PartOfDay.check(R.id.Afternoon);
                break;
            case "e":
                PartOfDay.check(R.id.Evening);
                break;
            case "n":
                PartOfDay.check(R.id.Night);
                break;
            default:
                PartOfDay.check(R.id.Morning);

                break;
        }
    }
    public void onclick(View view){
        if(rdbMorning.isChecked()){
            favouritePartOfDay = "m";
        }
        else if(rdbAfternoon.isChecked()){
            favouritePartOfDay = "a";
        }
        else if(rdbEvening.isChecked()){
            favouritePartOfDay = "e";
        }
        else if(rdbNight.isChecked()){
            favouritePartOfDay = "n";
        }
        else{
            favouritePartOfDay = "";
        }
        Log.i("fD",""+favouritePartOfDay);
    }
    public void savePreferences(){
        int mode = Activity.MODE_PRIVATE;
        android.content.SharedPreferences mySharedPreferences = getSharedPreferences(MYPREFS,mode);
        android.content.SharedPreferences.Editor editor = mySharedPreferences.edit();
        editor.putString("Name",editName.getText().toString());
        editor.putString("Address",editAddress.getText().toString());
        editor.putString("Phone",editPhone.getText().toString());
        editor.putString("Email",editEmail.getText().toString());
        editor.putString("favouritePartOfDay",favouritePartOfDay);
        editor.commit();
    }
    public void onStop(){
        super.onStop();
        this.savePreferences();
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_shared_preferences_main,menu);
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        int id = item.getItemId();
//        if(id == R.id.action_settings){
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
}