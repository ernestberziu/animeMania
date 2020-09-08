package com.threel.animeshqip;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

public class Welcome extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 1000;
    private ProgressBar mProgress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        mProgress = (ProgressBar) findViewById(R.id.splash_screen_progress_bar);



        // Start lengthy operation in a background thread
        new Thread(new Runnable() {
            public void run() {

                doWork();


                finish();
            }
        }).start();
    }


    private void doWork() {
        while (Demo.state==0) {
            for (int progress = 0; progress <=80; progress += 20) {
                try {
                    Thread.sleep(1000);
                    mProgress.setProgress(progress);


                } catch (Exception e) {
                    e.printStackTrace();

                }

            }
        }
        startApp();
    }
    private void startApp() {
        Intent intent = new Intent(Welcome.this, MainActivity.class);
        startActivity(intent);
    }

    public ProgressBar getmProgress() {
        return mProgress;
    }

    public void setmProgress(ProgressBar mProgress) {
        this.mProgress = mProgress;
    }


}


