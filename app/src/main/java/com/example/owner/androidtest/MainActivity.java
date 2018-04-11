package com.example.owner.androidtest;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);

        ImageView imageView = (ImageView) findViewById(R.id.ib);
        //imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setAdjustViewBounds(true);
        /*Display display = getWindowManager().getDefaultDisplay();
        Point myPoint = new Point();
        display.getSize(myPoint);


        imageView.setMinimumWidth(myPoint.x);
        imageView.setMinimumHeight(myPoint.y);

        imageView.setMaxWidth(myPoint.x);
        imageView.setMaxHeight(myPoint.y);*/
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ServantStats.class);
                startActivity(intent);
            }
        });
    }
}
