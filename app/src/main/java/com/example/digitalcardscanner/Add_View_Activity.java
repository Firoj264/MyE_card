package com.example.digitalcardscanner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class Add_View_Activity extends AppCompatActivity{

    ImageView back_button,plusbutton;
    RelativeLayout businesscard,nidcard,drivinglicense,transporlicense,visitingcard,certificates,bankcards,studentcards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_view);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        plusbutton=findViewById(R.id.plus_button);
        back_button=findViewById(R.id.back_button);

        businesscard=findViewById(R.id.businesscard);
        nidcard=findViewById(R.id.nidcard);
        visitingcard=findViewById(R.id.visitingcard);
        bankcards=findViewById(R.id.bankcards);

        drivinglicense=findViewById(R.id.drivinglicense);
        transporlicense=findViewById(R.id.transporlicense);
        certificates=findViewById(R.id.certificates);
        studentcards=findViewById(R.id.studentcards);



        transporlicense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=getPackageManager().getLaunchIntentForPackage("com.todobom.opennotescanner");
                startActivity(intent);
                finish();
            }
        });
        drivinglicense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=getPackageManager().getLaunchIntentForPackage("com.todobom.opennotescanner");
                startActivity(intent);
                finish();
            }
        });
        certificates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=getPackageManager().getLaunchIntentForPackage("com.todobom.opennotescanner");
                startActivity(intent);
                finish();
            }
        });
        nidcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=getPackageManager().getLaunchIntentForPackage("com.todobom.opennotescanner");
                startActivity(intent);
                finish();
            }
        });


        businesscard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=getPackageManager().getLaunchIntentForPackage("com.example.bcrapp");
                startActivity(intent);
                finish();
            }
        });
        studentcards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=getPackageManager().getLaunchIntentForPackage("com.example.bcrapp");
                startActivity(intent);
                finish();
            }
        });
        visitingcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=getPackageManager().getLaunchIntentForPackage("com.example.bcrapp");
                startActivity(intent);
                finish();
            }
        });
        bankcards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=getPackageManager().getLaunchIntentForPackage("com.example.bcrapp");
                startActivity(intent);
                finish();
            }
        });




        back_button.setOnClickListener(v -> {
            Intent intent=new Intent(Add_View_Activity.this,MainActivity.class);
            startActivity(intent);
        });
        plusbutton.setOnClickListener(v -> {
            Intent intent=new Intent(Add_View_Activity.this,AddNewcategory.class);
            startActivity(intent);
        });

    }
}