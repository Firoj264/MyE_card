package com.example.createcard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.digitalcardscanner.R;

public class panelActivity extends AppCompatActivity{

    public CardView card1, card2, card3,card4, card5, card6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panel);

        String nameToPass = getIntent().getStringExtra("namekey");
        String jobToPass = getIntent().getStringExtra("jobkey");
        String emailToPass = getIntent().getStringExtra("emailkey");
        String phoneToPass = getIntent().getStringExtra("phonekey");
        String adressToPass = getIntent().getStringExtra("adresskey");
        String siteToPass = getIntent().getStringExtra("sitekey");
        String companyToPass = getIntent().getStringExtra("companykey");
        String stringUri = getIntent().getStringExtra("uriString");


        card1 = (CardView) findViewById(R.id.c1);
        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(panelActivity.this, cardActivity.class);

                intent.putExtra("namex", nameToPass);
                intent.putExtra("jobx", jobToPass);
                intent.putExtra("emailx", emailToPass);
                intent.putExtra("phonex", phoneToPass);
                intent.putExtra("adressx", adressToPass);
                intent.putExtra("sitex", siteToPass);
                intent.putExtra("companyx", companyToPass);
                intent.putExtra("idcard", getResources().getResourceEntryName(card1.getId()));
                intent.putExtra("uriProfile", stringUri);


                startActivity(intent);
            }
        });

        card2 = (CardView) findViewById(R.id.c2);
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(panelActivity.this, cardActivity.class);

                intent.putExtra("namex", nameToPass);
                intent.putExtra("jobx", jobToPass);
                intent.putExtra("emailx", emailToPass);
                intent.putExtra("phonex", phoneToPass);
                intent.putExtra("adressx", adressToPass);
                intent.putExtra("sitex", siteToPass);
                intent.putExtra("companyx", companyToPass);
                intent.putExtra("idcard", getResources().getResourceEntryName(card2.getId()));
                intent.putExtra("uriProfile", stringUri);

                startActivity(intent);
            }
        });

        card3 = (CardView) findViewById(R.id.c3);
        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(panelActivity.this, cardActivity.class);

                intent.putExtra("namex", nameToPass);
                intent.putExtra("jobx", jobToPass);
                intent.putExtra("emailx", emailToPass);
                intent.putExtra("phonex", phoneToPass);
                intent.putExtra("adressx", adressToPass);
                intent.putExtra("sitex", siteToPass);
                intent.putExtra("companyx", companyToPass);
                intent.putExtra("idcard", getResources().getResourceEntryName(card3.getId()));
                intent.putExtra("uriProfile", stringUri);

                startActivity(intent);
            }
        });

        card4 = (CardView) findViewById(R.id.c4);
        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(panelActivity.this, cardActivity.class);

                intent.putExtra("namex", nameToPass);
                intent.putExtra("jobx", jobToPass);
                intent.putExtra("emailx", emailToPass);
                intent.putExtra("phonex", phoneToPass);
                intent.putExtra("adressx", adressToPass);
                intent.putExtra("sitex", siteToPass);
                intent.putExtra("companyx", companyToPass);
                intent.putExtra("idcard", getResources().getResourceEntryName(card4.getId()));
                intent.putExtra("uriProfile", stringUri);

                startActivity(intent);
            }
        });

        card5 = (CardView) findViewById(R.id.c5);
        card5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(panelActivity.this, cardActivity.class);

                intent.putExtra("namex", nameToPass);
                intent.putExtra("jobx", jobToPass);
                intent.putExtra("emailx", emailToPass);
                intent.putExtra("phonex", phoneToPass);
                intent.putExtra("adressx", adressToPass);
                intent.putExtra("sitex", siteToPass);
                intent.putExtra("companyx", companyToPass);
                intent.putExtra("idcard", getResources().getResourceEntryName(card5.getId()));
                intent.putExtra("uriProfile", stringUri);

                startActivity(intent);
            }
        });

        card6 = (CardView) findViewById(R.id.c6);
        card6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(panelActivity.this, cardActivity.class);

                intent.putExtra("namex", nameToPass);
                intent.putExtra("jobx", jobToPass);
                intent.putExtra("emailx", emailToPass);
                intent.putExtra("phonex", phoneToPass);
                intent.putExtra("adressx", adressToPass);
                intent.putExtra("sitex", siteToPass);
                intent.putExtra("companyx", companyToPass);
                intent.putExtra("idcard", getResources().getResourceEntryName(card6.getId()));
                intent.putExtra("uriProfile", stringUri);

                startActivity(intent);
            }
        });

    }


}