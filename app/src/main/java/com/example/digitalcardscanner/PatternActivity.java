package com.example.digitalcardscanner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.andrognito.patternlockview.PatternLockView;
import com.andrognito.patternlockview.listener.PatternLockViewListener;
import com.andrognito.patternlockview.utils.PatternLockUtils;

import java.util.List;

import io.paperdb.Paper;

public class PatternActivity extends AppCompatActivity {
    String save_pattern_key = "pattern_code";
    PatternLockView patternLockView;
    String final_pattern = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Paper.init(this);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        String save_pattern = Paper.book().read(save_pattern_key);
        if (save_pattern != null && !save_pattern.equals("null")) {
            setContentView(R.layout.pattern_layout);
            patternLockView = findViewById(R.id.pattern_lock_view);
            patternLockView.addPatternLockListener(new PatternLockViewListener() {
                @Override
                public void onStarted() {

                }

                @Override
                public void onProgress(List<PatternLockView.Dot> progressPattern) {

                }

                @Override
                public void onComplete(List<PatternLockView.Dot> pattern) {
                    final_pattern = PatternLockUtils.patternToString(patternLockView, pattern);
                    if (final_pattern.equals(save_pattern)) {
                        // patternLockView.setViewMode(PatternLockView.PatternViewMode.CORRECT);
                        Toast.makeText(PatternActivity.this, "Pattern Correct", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(PatternActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();

                    } else {
                        patternLockView.setViewMode(PatternLockView.PatternViewMode.WRONG);
                        Toast.makeText(PatternActivity.this, "Pattern Incorrect", Toast.LENGTH_SHORT).show();

                    }

                }

                @Override
                public void onCleared() {

                }
            });
        } else {
            setContentView(R.layout.activity_pattern);
            patternLockView = findViewById(R.id.pattern_lock_view);
            patternLockView.addPatternLockListener(new PatternLockViewListener() {
                @Override
                public void onStarted() {

                }

                @Override
                public void onProgress(List<PatternLockView.Dot> progressPattern) {

                }

                @Override
                public void onComplete(List<PatternLockView.Dot> pattern) {
                    final_pattern = PatternLockUtils.patternToString(patternLockView, pattern);

                }

                @Override
                public void onCleared() {

                }
            });
            Button button = findViewById(R.id.button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Paper.book().write(save_pattern_key, final_pattern);
                    Toast.makeText(PatternActivity.this, "Saved Pattern", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(PatternActivity.this, MainActivity.class);
                    startActivity(intent);

                }
            });
        }
    }
}