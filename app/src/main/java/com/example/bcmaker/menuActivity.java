package com.example.bcmaker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.digitalcardscanner.R;

public class menuActivity extends AppCompatActivity {

    private Button btnNew, btnStored;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnNew = findViewById(R.id.btnNew);
        btnStored = findViewById(R.id.btnStored);

        btnNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(menuActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        btnStored.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Intent intent = new Intent(menuActivity.this, savedActivity.class);
                 startActivity(intent);
            }
        });


    }
}