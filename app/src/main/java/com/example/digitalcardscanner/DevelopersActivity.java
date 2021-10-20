package com.example.digitalcardscanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class DevelopersActivity extends AppCompatActivity {
    ImageView back_button;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developers);
        back_button=findViewById(R.id.back_button);
        button=findViewById(R.id.buttondevelopersback);

        back_button.setOnClickListener(v -> {
            Intent intent=new Intent(DevelopersActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        });
        button.setOnClickListener(v -> {
            Intent intent=new Intent(DevelopersActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}