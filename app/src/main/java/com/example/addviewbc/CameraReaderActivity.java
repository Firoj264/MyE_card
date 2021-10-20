package com.example.addviewbc;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.util.SparseArray;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.digitalcardscanner.R;
import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.text.TextBlock;
import com.google.android.gms.vision.text.TextRecognizer;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CameraReaderActivity extends AppCompatActivity {

    private SurfaceView cameraView;
    private CameraSource cameraSource;
    private TextView textView;
    private final int REQUEST_CAMERA_PERMISSION_ID = 1001;
    private final String TAG = "CameraReaderActivity";
    public static final String PROFILE_DATA_KEY = "profile_data_key";
    private final int CAMERA_TIME = 10000;
    private List<String> profile_data = new ArrayList<String>();
    private Handler handler = new Handler();

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case REQUEST_CAMERA_PERMISSION_ID:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                            != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(CameraReaderActivity.this,
                                new String[]{Manifest.permission.CAMERA},
                                REQUEST_CAMERA_PERMISSION_ID);
                        return;
                    }
                    try {
                        cameraSource.start(cameraView.getHolder());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
                break;
            default:
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_reader);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        cameraView = (SurfaceView) findViewById(R.id.surface_view);
        textView = (TextView) findViewById(R.id.text_view);
        TextRecognizer textRecognizer = new TextRecognizer.Builder(getApplicationContext())
                .build();
        if (!textRecognizer.isOperational()){
            Log.w(TAG, "Text recognizer is not operational!");
        } else {
            cameraSource = new CameraSource.Builder(getApplicationContext(), textRecognizer)
                    .setFacing(CameraSource.CAMERA_FACING_BACK)
                    .setRequestedPreviewSize(1280,1024)
                    .setRequestedFps(2.0f)
                    .setAutoFocusEnabled(true)
                    .build();
            cameraView.getHolder().addCallback(new SurfaceHolder.Callback(){
                @Override
                public void surfaceCreated(SurfaceHolder surfaceHolder){
                    if (ActivityCompat.checkSelfPermission(getApplicationContext(),
                            Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
                        ActivityCompat.requestPermissions(CameraReaderActivity.this,
                                new String[] {Manifest.permission.CAMERA},
                                REQUEST_CAMERA_PERMISSION_ID);
                        return;
                    }
                    try {
                        cameraSource.start(cameraView.getHolder());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                @Override
                public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2){

                }
                @Override
                public void surfaceDestroyed(SurfaceHolder surfaceHolder){
                    cameraSource.stop();
                }

            });
            textRecognizer.setProcessor(new Detector.Processor<TextBlock>(){

                @Override
                public void release() {

                }

                @Override
                public void receiveDetections(Detector.Detections<TextBlock> detections) {
                    final SparseArray<TextBlock> items = detections.getDetectedItems();
                    if (items.size() != 0){
                        textView.post(new Runnable(){
                            @Override
                            public void run() {
                                StringBuilder sb = new StringBuilder();
                                for (int i=0; i<items.size(); i++){
                                    sb.append(items.valueAt(i).getValue()).append("\n");
                                }
                                String capturedString = sb.toString();
                                textView.setText(capturedString);
                                if (StringUtils.isNotBlank(capturedString)){
                                    profile_data.add(capturedString);
                                }
                            }
                        });
                    }
                }
            });
        }
        handler.postDelayed(new Runnable(){
            @Override
            public void run() {
                Toast.makeText(CameraReaderActivity.this, "Complete Scan", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(CameraReaderActivity.this, ProfileCreatorActivity.class);
                intent.putStringArrayListExtra(PROFILE_DATA_KEY, (ArrayList<String>) profile_data);
                startActivity(intent);
                finish();
            }
        }, CAMERA_TIME);
    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(CameraReaderActivity.this, MainActivitybcr.class);
        startActivity(intent);
        finish();
    }
}