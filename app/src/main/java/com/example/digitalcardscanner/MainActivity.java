package com.example.digitalcardscanner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.contactapp.MainActivityimportcontact;
import com.example.digitalvisitingcard.MainActivitytransfer;
import com.example.qrcodescanner.Activity.LaunchScreenActivity;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private Button button;
    RelativeLayout addview,scan,chats,createcard,imports,transfer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        addview=findViewById(R.id.addview);
        scan=findViewById(R.id.scanqr);
        chats=findViewById(R.id.chats);
        createcard=findViewById(R.id.createcard);
        imports=findViewById(R.id.importcontacts);
        transfer=findViewById(R.id.transfer);

        MaterialToolbar toolbar = findViewById(R.id.topAppBar);
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.navigation_view);

        addview.setOnClickListener(v -> {
            Intent intent=new Intent(MainActivity.this,Add_View_Activity.class);
            startActivity(intent);
        });
        createcard.setOnClickListener(v -> {
            Intent intent=new Intent(MainActivity.this,CreateCardActivity.class);
            startActivity(intent);
        });
        imports.setOnClickListener(v -> {
            Intent intent=new Intent(MainActivity.this, MainActivityimportcontact.class);
            startActivity(intent);
        });
        transfer.setOnClickListener(v -> {
            Intent intent=new Intent(MainActivity.this, MainActivitytransfer.class);
            startActivity(intent);
        });
        scan.setOnClickListener(v -> {
            Intent intent=new Intent(MainActivity.this, LaunchScreenActivity.class);
            startActivity(intent);
        });
        chats.setOnClickListener(v -> {
            Intent intent=getPackageManager().getLaunchIntentForPackage("com.example.mychatapp");
            startActivity(intent);
        });


        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                drawerLayout.openDrawer(GravityCompat.START);

            }
        });
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @org.jetbrains.annotations.NotNull MenuItem item) {

                int id = item.getItemId();
                drawerLayout.closeDrawer(GravityCompat.START);
                switch (id)
                {

                    case R.id.nav_home:
                        Toast.makeText(MainActivity.this, "Home is Clicked", Toast.LENGTH_SHORT).show();break;
                    case R.id.nav_message:
                        Toast.makeText(MainActivity.this, "Message is Clicked",Toast.LENGTH_SHORT).show();break;
                    case R.id.synch:
                        Toast.makeText(MainActivity.this, "Synch is Clicked",Toast.LENGTH_SHORT).show();break;
                    case R.id.trash:
                        Toast.makeText(MainActivity.this, "Trash is Clicked",Toast.LENGTH_SHORT).show();break;
                    case R.id.settings:
                        Toast.makeText(MainActivity.this, "Settings is Clicked",Toast.LENGTH_SHORT).show();break;
                    case R.id.nav_login:
                       Intent intent=new Intent(MainActivity.this,LoginActivity.class);
                       startActivity(intent);
                       finish();
                       break;
                    case R.id.nav_share:
                        try{
                            Intent i=new Intent(Intent.ACTION_SEND);
                            i.setType("text/plain");
                            i.putExtra(Intent.EXTRA_SUBJECT,"My E-card");
                            i.putExtra(Intent.EXTRA_TEXT,"");
                            startActivity(Intent.createChooser(i,"Share with"));
                            Toast.makeText(MainActivity.this, "Share",Toast.LENGTH_SHORT).show();

                        }catch (Exception e){
                            Toast.makeText(MainActivity.this, "Unable to Share",Toast.LENGTH_SHORT).show();
                        }
                        break;
                }
                return true;
            }
        });


    }
}