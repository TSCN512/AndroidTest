package com.example.owner.androidtest;

import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import android.os.AsyncTask;
import java.io.IOException;

public class ServantStats extends AppCompatActivity
{
    Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_servant_stats);
        final EditText ET = (EditText) findViewById(R.id.editText);
        ET.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_CLASS_NUMBER);
        final Button submit = (Button) findViewById(R.id.servantButton);
        final TextView TV = (TextView) findViewById(R.id.textView);
        final ImageView IV = (ImageView) findViewById(R.id.imageView);
        submit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //boolean isInt = true;
                //String ID = ET.getText().toString();
                int ID = Integer.parseInt(ET.getText().toString());
                Servant newServant = new Servant(ID);
                TV.setText(newServant.toString());
                Portrait pic = new Portrait();
                pic.setImage(IV);
                pic.execute(newServant.getImageURL());


            }
        });
    }


}
