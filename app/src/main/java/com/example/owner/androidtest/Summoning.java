package com.example.owner.androidtest;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Summoning extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_summoning);

        //getActionBar().setDisplayHomeAsUpEnabled(true);
        final Button summon10 = (Button) findViewById(R.id.summon10);
        final TextView TV1 = (TextView) findViewById(R.id.summoning_tv1);
        final TextView TV2 = (TextView) findViewById(R.id.summoning_tv2);
        final TextView TV3 = (TextView) findViewById(R.id.summoning_tv3);
        final ProgressBar progress = (ProgressBar)findViewById(R.id.progressBar);
        //final ImageView IV = (ImageView) findViewById(R.id.imageView);
        final TextView TV4 = (TextView) findViewById(R.id.quartzCount);
        final TextView TV5 = (TextView) findViewById(R.id.quartzCount2);
        final Gacha myGacha = new Gacha(progress, TV1, TV2, TV3, summon10, TV4, TV5);
        TV1.setText("5★ & 4★ Servants");
        TV2.setText("5★ Craft Essences");
        TV3.setText("Results Appear Here");
        TV4.setText("Quartz Spent: ");
        TV5.setText("Money Spent: ");
        summon10.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                summon10.setEnabled (false);

                myGacha.tenPull();
                new Gacha_task().execute(myGacha);



            }
        });
    }

}
