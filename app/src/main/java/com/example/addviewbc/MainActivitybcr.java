package com.example.addviewbc;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.digitalcardscanner.Add_View_Activity;
import com.example.digitalcardscanner.MainActivity;
import com.example.digitalcardscanner.R;

public class MainActivitybcr extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private Button profileListButton;
    private Button cameraReaderButton;
    private ImageView backbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainbcr);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        profileListButton = (Button) findViewById(R.id.profileListButton);
        cameraReaderButton = (Button) findViewById(R.id.cameraReaderButton);
        backbutton=  findViewById(R.id.back_buttonbcr);

        profileListButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Intent intent = new Intent(MainActivitybcr.this, ProfileListActivity.class);
                startActivity(intent);
                finish();
            }
        });
        cameraReaderButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Intent intent = new Intent(MainActivitybcr.this, CameraReaderActivity.class);
                startActivity(intent);
            }
        });

        backbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Intent intent = new Intent(MainActivitybcr.this, Add_View_Activity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed(){
       /* moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);*/
        Intent intent = new Intent(MainActivitybcr.this, Add_View_Activity.class);
        startActivity(intent);
    }
}