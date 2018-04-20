package com.example.owner.androidtest;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

public class Portrait extends AsyncTask<String, Void, Void>
{
    Bitmap bitmap;
    ImageView IV;
    @Override
    public Void doInBackground(String ... imgURL)
    {
        try
        {
            InputStream input = new java.net.URL(imgURL[0]).openStream();
            bitmap = BitmapFactory.decodeStream(input);
        }
        catch(IOException e)
        {
            Log.d("PORTRAIT", "The IOException: " + e.getMessage());
        }
        return null;
    }
    @Override
    public void onPostExecute(Void result) {
        //do stuff
        IV.setImageBitmap(bitmap);
    }
    public void setImage(ImageView iv)
    {
        this.IV = iv;
    }
}
