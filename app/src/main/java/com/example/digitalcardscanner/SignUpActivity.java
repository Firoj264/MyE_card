package com.example.digitalcardscanner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;

public class SignUpActivity extends AppCompatActivity {

    private static final String TAG = "CreateAccount";
    EditText name,email,password,confirmpassword;
    TextView linklogin;
    AppCompatButton btnSignUp;
    ImageView back_button;

    public String password1;
    public String confirmpassword1;
    public String email1;
    public static SharedPreferences sref;
    ProgressDialog progressDialog;

    FirebaseAuth mAuth;
    FirebaseUser mUser;

    String emailPattern = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);



        btnSignUp = findViewById(R.id.btn_signup);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password =  findViewById(R.id.password);
        confirmpassword =  findViewById(R.id.confirm_password);
        back_button =  findViewById(R.id.back_button);
        linklogin=findViewById(R.id.link_signin);
        progressDialog=new ProgressDialog(this);

        mAuth=FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();


        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SignUpActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

        linklogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SignUpActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PerForAuth();
            }
        });


    }

    private void PerForAuth() {
        email1=email.getText().toString();
        password1=password.getText().toString();
        confirmpassword1=confirmpassword.getText().toString();

        if(!email1.matches(emailPattern))
        {
            email.setError("Enter Correct Email");
        }else if (password1.isEmpty()||password1.length()<6){
            password.setError("Enter at least 6 password");
        }else if (!password1.equals(confirmpassword1)){
            confirmpassword.setError("Password not match both field");
        }else{

            progressDialog.setMessage("Please wait while registration.....");
            progressDialog.setTitle("Registration");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.createUserWithEmailAndPassword(email1,password1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if (task.isSuccessful()){
                        progressDialog.dismiss();
                        SendUserToNextActivity();
                        Toast.makeText(SignUpActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                    }else {
                        progressDialog.dismiss();
                        Toast.makeText(SignUpActivity.this, "Invalid Email or Password", Toast.LENGTH_SHORT).show();
                    }

                }
            });

        }
    }

    private void SendUserToNextActivity() {
        Intent intent=new Intent(SignUpActivity.this,LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}