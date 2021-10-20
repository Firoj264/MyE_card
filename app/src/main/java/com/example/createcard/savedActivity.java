package com.example.createcard;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.digitalcardscanner.MainActivity;
import com.example.digitalcardscanner.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

public class savedActivity extends AppCompatActivity {
    private static final int SELECT_PICTURE = 100;
    private static final String TAG = "savedActivity";
    private TextView finalName, finalJob, finalEmail, finalPhone, finalAdress, finalSite, finalCompany;
    private ImageView templateImg;
    private ImageView finalImgProfile;
    public Uri imgUri;
    Button share,gotohome;
    ImageView backbtn;

    private FirebaseStorage storage;
    private StorageReference storageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved);

            finalName = findViewById(R.id.savedNume);
            finalJob = findViewById(R.id.savedJob);
            finalEmail = findViewById(R.id.savedEmail);
            finalPhone = findViewById(R.id.savedPhone);
            finalAdress = findViewById(R.id.savedAdress);
            finalSite = findViewById(R.id.savedSite);
            finalCompany = findViewById(R.id.savedCompany);
            templateImg = findViewById(R.id.savedtemplateCard);
            finalImgProfile = findViewById(R.id.savedImgProfile);
            share = findViewById(R.id.share);
            gotohome = findViewById(R.id.gotohompage);
            backbtn = findViewById(R.id.back_button);


        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();

        StorageReference profileRef = storageReference.child("profile.jpg");

        profileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).into(finalImgProfile);
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent i=new Intent(Intent.ACTION_SEND);
                    i.setType("text/plain");
                    i.putExtra(Intent.EXTRA_SUBJECT,"My E-card");
                    i.putExtra(Intent.EXTRA_TEXT,"");
                    startActivity(Intent.createChooser(i,"Share with"));
                    Toast.makeText(savedActivity.this, "Share",Toast.LENGTH_SHORT).show();

                }catch (Exception e){
                    Toast.makeText(savedActivity.this, "Unable to Share",Toast.LENGTH_SHORT).show();
                }
            }
        });

        gotohome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(savedActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(savedActivity.this,menuActivity.class);
                startActivity(intent);
            }
        });


        SharedPreferences myPref = getSharedPreferences("myKey", MODE_PRIVATE);
            String nameSaved = myPref.getString("savename","Name");
            String jobSaved = myPref.getString("savejob", "Job");
            String companySaved = myPref.getString("savecompany", "Company");
            String emailSaved = myPref.getString("saveemail", "Email");
            String phoneSaved = myPref.getString("savephone", "Phone number");
            String adressSaved = myPref.getString("saveadress", "Adress");
            String siteSaved = myPref.getString("savesite", "Website");


            finalName.setText(nameSaved);
            finalJob.setText(jobSaved);
            finalCompany.setText(companySaved);
            finalEmail.setText(emailSaved);
            finalPhone.setText(phoneSaved);
            finalAdress.setText(adressSaved);
            finalSite.setText(siteSaved);

            String idcardSaved = myPref.getString("savecardid","c1");

        switch (idcardSaved)
        {
            case "c1" :
                templateImg.setImageResource(R.mipmap.card1);
                break;
            case "c2":
                templateImg.setImageResource(R.mipmap.card2);
                break;
            case "c3":
                templateImg.setImageResource(R.mipmap.card3);
                break;
            case "c4":
                templateImg.setImageResource(R.mipmap.card4);
                break;
            case "c5":
                templateImg.setImageResource(R.mipmap.card5);
                break;
            case "c6":
                templateImg.setImageResource(R.mipmap.card6);
                break;
        }

    }


}
