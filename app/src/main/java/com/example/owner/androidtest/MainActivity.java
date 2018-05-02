package com.example.owner.androidtest;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Point;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);

        final Button feature1 = (Button) findViewById(R.id.feature1);
        final Button feature2 = (Button) findViewById(R.id.feature2);
        final Button feature3 = (Button) findViewById(R.id.feature3);
        final TextView inProgress = (TextView) findViewById(R.id.inProgress);
        /*Display display = getWindowManager().getDefaultDisplay();
        Point myPoint = new Point();
        display.getSize(myPoint);


        imageView.setMinimumWidth(myPoint.x);
        imageView.setMinimumHeight(myPoint.y);

        imageView.setMaxWidth(myPoint.x);
        imageView.setMaxHeight(myPoint.y);*/
        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

            StrictMode.setThreadPolicy(policy);
        }
        feature1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ServantStats.class); //before was MainActivity.this, ServantStats.class
                startActivity(intent);
            }
        });
        feature2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Summoning.class); //before was MainActivity.this, ServantStats.class
                startActivity(intent);
            }
        });
        feature3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(MainActivity.this, Summoning.class); //before was MainActivity.this, ServantStats.class
                //startActivity(intent);
                inProgress.setText("Coming Soon");
            }
        });
    }
}
