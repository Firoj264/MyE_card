package com.example.digitalcardscanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class AboutActivity extends AppCompatActivity {
    ImageView back_button1;
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        back_button1=findViewById(R.id.back_button);
        button1=findViewById(R.id.buttonaboutback);

        back_button1.setOnClickListener(v -> {
            Intent intent=new Intent(AboutActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        });
        button1.setOnClickListener(v -> {
            Intent intent=new Intent(AboutActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}