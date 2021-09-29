package com.example.digitalcardscanner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class AddNewcategory extends AppCompatActivity {

    ImageView backbutton;
    AppCompatButton addbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_newcategory);

        backbutton=findViewById(R.id.back_button);
        addbtn=findViewById(R.id.btn_add);

        backbutton.setOnClickListener(v -> {
            Intent intent=new Intent(AddNewcategory.this,Add_View_Activity.class);
            startActivity(intent);
        });
        addbtn.setOnClickListener(v -> {
            Intent intent=new Intent(AddNewcategory.this,Add_View_Activity.class);
            startActivity(intent);
        });


    }
}