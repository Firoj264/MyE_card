package com.example.digitalcardscanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.createcard.menuActivity;

public class CreateCardActivity extends AppCompatActivity {

    private Button button1;
    ImageView back_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_card);

        button1=findViewById(R.id.button1);
        back_button=findViewById(R.id.back_button);

        back_button.setOnClickListener(v -> {
            Intent intent=new Intent(CreateCardActivity.this,MainActivity.class);
            startActivity(intent);
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CreateCardActivity.this, menuActivity.class);
                startActivity(intent);
            }
        });
    }
}