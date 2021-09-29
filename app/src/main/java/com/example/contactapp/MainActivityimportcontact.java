package com.example.contactapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.digitalcardscanner.R;

public class MainActivityimportcontact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maincontact);

        //ActionBar myActionBar = getSupportActionBar();
        //myActionBar.hide();

    }
    public void doNavigate(View v){
        switch (v.getId()){
            case R.id.flAdd:
                Intent add = new Intent(MainActivityimportcontact.this, AddContactActivity.class);
                startActivity(add);
                break;
            case R.id.flView:
                Intent view = new Intent(MainActivityimportcontact.this, ContactViewActivity.class);
                startActivity(view);
                break;
            case R.id.flImport:
                Intent imprt = new Intent(MainActivityimportcontact.this, ImportActivity.class);
                startActivity(imprt);
                break;
            case R.id.flExpert:
                break;
        }
    }
}