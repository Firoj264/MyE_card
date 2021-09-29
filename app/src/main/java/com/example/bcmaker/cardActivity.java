package com.example.bcmaker;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.digitalcardscanner.R;

import java.io.Serializable;

public class cardActivity extends AppCompatActivity implements Serializable {

    private static final String TAG = "cardActivity";

    private TextView finalName, finalJob, finalEmail, finalPhone, finalAdress, finalSite, finalCompany;
    private ImageView templateImg;
    private TextView templateTxt;
    private ImageView finalImgProfile;
    private Button saveCard;
    ProgressBar progressBar;
    public static boolean activated = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        saveCard = findViewById(R.id.btnSave);

        finalName = findViewById(R.id.Nume1);
        finalJob = findViewById(R.id.Job1);
        finalEmail = findViewById(R.id.Email1);
        finalPhone = findViewById(R.id.Phone1);
        finalAdress = findViewById(R.id.Adress1);
        finalSite = findViewById(R.id.Site1);
        finalCompany = findViewById(R.id.Company1);

        templateImg = findViewById(R.id.templateCard);
        templateTxt = findViewById(R.id.templateText);

        finalImgProfile = findViewById(R.id.finalImgProfile);





        String namer = getIntent().getStringExtra("namex");
        String jobr = getIntent().getStringExtra("jobx");
        String emailr = getIntent().getStringExtra("emailx");
        String phoner = getIntent().getStringExtra("phonex");
        String adressr = getIntent().getStringExtra("adressx");
        String siter = getIntent().getStringExtra("sitex");
        String companyr = getIntent().getStringExtra("companyx");
        String idcardr = getIntent().getStringExtra("idcard");
        String uriProfile = getIntent().getStringExtra("uriProfile");

        Uri imgUri;
        imgUri = Uri.parse(uriProfile);
        finalImgProfile.setImageURI(imgUri);

        Log.d(TAG, "PRIMA SURSA:::" + imgUri.toString());

        switch (idcardr)
        {
            case "c1" :
                templateImg.setImageResource(R.mipmap.card1);
                templateTxt.setText("Personal Card");
                break;
            case "c2":
                templateImg.setImageResource(R.mipmap.card2);
                templateTxt.setText("Science Card");
                break;
            case "c3":
                templateImg.setImageResource(R.mipmap.card3);
                templateTxt.setText("Sales Card");
                break;
            case "c4":
                templateImg.setImageResource(R.mipmap.card4);
                templateTxt.setText("Architecture Card");
                break;
            case "c5":
                templateImg.setImageResource(R.mipmap.card5);
                templateTxt.setText("Vechicles Card");
                break;
            case "c6":
                templateImg.setImageResource(R.mipmap.card6);
                templateTxt.setText("Construction Card");
                break;
        }

        finalName.setText(namer);
        finalJob.setText(jobr);
        finalEmail.setText(emailr);
        finalPhone.setText(phoner);
        finalAdress.setText(adressr);
        finalSite.setText(siter);
        finalCompany.setText(companyr);

        saveCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activated = true;
                SharedPreferences myPref = getSharedPreferences("myKey", MODE_PRIVATE);
                SharedPreferences.Editor myEditor = myPref.edit();
                myEditor.putString("savename", namer);
                myEditor.putString("savejob",jobr);
                myEditor.putString("savecompany", companyr);
                myEditor.putString("savephone",phoner);
                myEditor.putString("saveemail", emailr);
                myEditor.putString("saveadress", adressr);
                myEditor.putString("savesite",siter);
                myEditor.putString("savecardid", idcardr);
                myEditor.putString("saveuri", uriProfile);

                myEditor.apply();

                Toast.makeText(cardActivity.this, "Your card Saved", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(cardActivity.this,savedActivity.class);
                startActivity(intent);
                finish();


            }
        });


    }

}