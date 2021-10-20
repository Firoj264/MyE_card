package com.example.digitalcardscanner;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.createcard.menuActivity;
import com.example.scanner.Activity.LaunchScreenActivity;
import com.example.transfer.MainActivitytransfer;

public class ScanActivity extends AppCompatActivity {

    Button scan,generate;
    ImageView back_button1;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);

        scan=findViewById(R.id.scanqrbutton);
        generate=findViewById(R.id.generateqrbutton);
        back_button1=findViewById(R.id.back_button);

        back_button1.setOnClickListener(v -> {
            Intent intent=new Intent(ScanActivity.this,MainActivity.class);
            startActivity(intent);
        });

        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ScanActivity.this, LaunchScreenActivity.class);
                startActivity(intent);
            }
        });
        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ScanActivity.this, MainActivitytransfer.class);
                startActivity(intent);
            }
        });


    }
}