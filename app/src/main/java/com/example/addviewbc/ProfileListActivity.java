package com.example.addviewbc;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.digitalcardscanner.R;

import java.util.ArrayList;
import java.util.List;

public class ProfileListActivity extends AppCompatActivity {

    private ProfileDao profileDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_list);
        profileDao = ProfileDao.getInstance(this);
        ListView listView = (ListView) findViewById(R.id.list_view);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Cursor profileData = profileDao.loadDataForMinimalList();
        if (profileData == null){
            Utils.displayErrorDialog(this);
        }else {
            List<String> profileItems = new ArrayList<String>();
            for(profileData.moveToFirst(); !profileData.isAfterLast(); profileData.moveToNext()){
                StringBuilder sb = new StringBuilder();
                sb.append(profileData.getString(1))
                        .append(" / ")
                        .append(profileData.getString(2))
                        .append(ProfileArrayAdapter.DELIMITER)
                        .append(profileData.getString(0));
                profileItems.add(sb.toString());
            }
            Log.d(ProfileListActivity.class.getName(), "Found "+profileItems.size()+" profiles in list");
            profileData.close();

            ProfileArrayAdapter adapter = new ProfileArrayAdapter(
                    this,
                    profileItems.toArray(new String[profileItems.size()])
            );
            listView.setAdapter(adapter);
            adapter.notifyDataSetChanged();

        }


    }
    @Override
    public void onBackPressed(){
        Intent intent = new Intent(ProfileListActivity.this, MainActivitybcr.class);
        startActivity(intent);
        finish();
    }
}