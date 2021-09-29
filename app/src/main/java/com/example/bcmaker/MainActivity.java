package com.example.bcmaker;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.digitalcardscanner.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements Serializable{

    private static final String TAG = "MainActivity";
    private EditText edtName, edtEmail, edtJob, edtAdress,edtPhone, edtSite, edtCompany;
    private Button btnImage, btnCreate;
    private TextView warnName, warnEmail, warnJob, warnAdress, warnPhone, warnSite, warnCompany;
    private Spinner countrySpinner;
    private RadioGroup rgGender;
    private CheckBox agreementCheck;
    private ConstraintLayout parent;
    public Uri imageUri;
    private ImageView imgProfile;
    private FirebaseStorage storage;
    private StorageReference storageReference;
    private boolean imageUploaded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        initViews();

        ActivityResultLauncher<Intent> someActivity = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if(result.getResultCode() == Activity.RESULT_OK)
                        {
                            Intent intent = result.getData();

                            assert intent != null;
                            imageUri = intent.getData();

                            imgProfile.setImageURI(imageUri);

                            uploadPicture();

                        }
                    }
                }
        );

        btnImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //choosePicture();
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                someActivity.launch(intent);
            }
        });

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(imageUploaded == false)
                {

                    Toast.makeText(MainActivity.this, "Uploading an image is mandatory!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    initPanel();
                }
            }
        });


    }


    private void uploadPicture() {
        final ProgressDialog pd = new ProgressDialog(this);
        pd.setTitle("Uploading Image...");
        pd.show();

        StorageReference ImagesRef = storageReference.child("profile.jpg");

        ImagesRef.putFile(imageUri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        pd.dismiss();
                        Snackbar.make(findViewById(android.R.id.content), "Image Uploaded", Snackbar.LENGTH_LONG).show();
                        imageUploaded = true;
                    }
                })
        .addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                pd.dismiss();
                Toast.makeText(MainActivity.this, "Failed to Upload", Toast.LENGTH_SHORT).show();
            }
        })
        .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {
                double progressPercent = (100.00 * snapshot.getBytesTransferred() / snapshot.getTotalByteCount());
                pd.setMessage("Loading: " + (int) progressPercent + "%");
            }
        });

        ImagesRef.getName().equals(ImagesRef.getName());    // true
        ImagesRef.getPath().equals(ImagesRef.getPath());    // false
    }

    private void initViews()
    {
        Log.d(TAG, "initViews: Started");
        edtName = findViewById(R.id.edtName);
        edtEmail = findViewById(R.id.edtEmail);
        edtCompany = findViewById(R.id.edtCompany);
        edtJob = findViewById(R.id.edtJob);
        edtAdress = findViewById(R.id.edtAdress);
        edtPhone = findViewById(R.id.edtPhone);
        edtSite =findViewById(R.id.edtSite);

        warnAdress = findViewById(R.id.warnAdress);
        warnCompany = findViewById(R.id.warnCompany);
        warnEmail = findViewById(R.id.warnEmail);
        warnJob = findViewById(R.id.warnJob);
        warnName = findViewById(R.id.warnName);
        warnPhone = findViewById(R.id.warnPhone);
        warnSite = findViewById(R.id.warnSite);

        btnImage = findViewById(R.id.btnImage);
        btnCreate = findViewById(R.id.btnCreate);


        imgProfile = findViewById(R.id.imgProfile);

        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();


        StorageReference profileRef = storageReference.child("profile.jpg");
        profileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).into(imgProfile);
            }
        });



        countrySpinner = findViewById(R.id.countrySpinner);
        rgGender = findViewById(R.id.rgGender);
        parent = findViewById(R.id.parent);
    }
    private void initPanel()
    {
        if(validateData())
        {
                String nameSt, jobSt, emailSt, phoneSt, adressSt,siteSt, companySt;
                nameSt = edtName.getText().toString();
                jobSt = edtJob.getText().toString();
                emailSt = edtEmail.getText().toString();
                phoneSt = edtPhone.getText().toString();
                adressSt = edtAdress.getText().toString();
                siteSt = edtSite.getText().toString();
                companySt = edtCompany.getText().toString();

                Intent i = new Intent(MainActivity.this, panelActivity.class);

                i.putExtra("namekey", nameSt);
                i.putExtra("jobkey", jobSt);
                i.putExtra("emailkey", emailSt);
                i.putExtra("phonekey", phoneSt);
                i.putExtra("adresskey", adressSt);
                i.putExtra("sitekey", siteSt);
                i.putExtra("companykey", companySt);
                i.putExtra("uriString", imageUri.toString());

                startActivity(i);
            }
        else
        {
            Toast.makeText(this, "Fill in all the fileds!", Toast.LENGTH_SHORT).show();
        }
    }



    private boolean validateData()
    {
        Log.d(TAG, "validateData: Started");
        if(edtName.getText().toString().equals(""))
        {
            warnName.setVisibility(View.VISIBLE);
            warnName.setText("Enter your name");
            return false;
        }
        else
        {
            warnName.setVisibility(View.GONE);
        }

        if(edtSite.getText().toString().equals(""))
        {
            warnSite.setVisibility(View.VISIBLE);
            warnSite.setText("Enter Website");
            return false;
        }
        else
        {
            warnSite.setVisibility(View.GONE);
        }
        if(edtJob.getText().toString().equals(""))
        {
            warnJob.setVisibility(View.VISIBLE);
            warnJob.setText("Enter Job");
            return false;
        }
        else
        {
            warnJob.setVisibility(View.GONE);
        }

        if(edtAdress.getText().toString().equals(""))
        {
            warnAdress.setVisibility(View.VISIBLE);
            warnAdress.setText("Enter Adress");
            return false;
        }
        else
        {
            warnAdress.setVisibility(View.GONE);
        }

        if(edtPhone.getText().toString().equals(""))
        {
            warnPhone.setVisibility(View.VISIBLE);
            warnPhone.setText("Enter Phone number");
            return false;
        }
        else
        {
            warnPhone.setVisibility(View.GONE);
        }

        if(edtEmail.getText().toString().equals(""))
        {
            warnEmail.setVisibility(View.VISIBLE);
            warnEmail.setText("Enter Email");
            return false;
        }
        else
        {
            warnEmail.setVisibility(View.GONE);
        }

        if(edtCompany.getText().toString().equals(""))
        {
            warnCompany.setVisibility(View.VISIBLE);
            warnCompany.setText("Enter Company");

            return false;
        }
        else
        {
            warnCompany.setVisibility(View.GONE);
        }

        return true;
    }



}