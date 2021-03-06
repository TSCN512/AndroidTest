package com.example.owner.androidtest;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Gacha
{

    Random rand = new Random();
    int[] pulls = new int[6]; //0,1,2 are servants SSR -> R, 3,4,5 are CEs SSR -> R
    double cost_best = 0.00;
    double cost_worst = 0.00;
    int quartz = 0;
    int card_id;
    String last_result = "";
    HashMap SSR_Servants = new HashMap();
    HashMap SR_Servants = new HashMap();
    //ArrayList<String> R_Servants = new ArrayList<>();
    HashMap SSR_CEs = new HashMap();
    //ArrayList<String> SR_CEs = new ArrayList<>();
    //ArrayList<String> R_CEs = new ArrayList<>();
    int[] valid5CEs = {31,32,33,34,35,40,48,57,58,67,75,97,175,185,188};
    int[] valid4CEs = {21,22,23,24,25,26,27,28,29,30,38,39,47,56,66,73,74,98,176,186};
    int[] valid3CEs = {49,55,65,72,89,90,91,92,93,94,95,96,187};
    int[] valid5Servants = {2,8,37,52,59,60,62,65,75,76,77,84,85,97,98,99,106};
    int[] valid4Servants = {3,5,6,10,11,14,18,29,30,41,46,47,48,58,66,67,74,78,82,87,89,94,100,101,102,103,109};
    int[] valid3Servants = {7,9,13,15,17,20,22,23,26,27,28,31,32,35,38,42,49,55,56,63,64,71,72,79,80,81,95,104,105,110};
    ProgressBar bar;
    TextView TV1;
    TextView TV2;
    TextView TV3;
    TextView TV4;
    TextView TV5;
    Button theButton;
    public Gacha(ProgressBar progress, TextView tv1, TextView tv2, TextView tv3, Button myButton, TextView tv4, TextView tv5)
    {
        bar = progress;
        TV1 = tv1;
        TV2 = tv2;
        TV3 = tv3;
        TV4 = tv4;
        TV5 = tv5;
        theButton = myButton;
    }


    public void tenPull()
    {

        quartz += 30;
        cost_best = quartz * .57;
        cost_worst = quartz;
        for (int i = 0; i < 10; i++) {
            int pull = rand.nextInt(100);
            if (pull == 0)
                pulls[0]++;
            else if (pull > 0 && pull < 4)
                pulls[1]++;
            else if (pull > 3 && pull < 44)
                pulls[2]++;
            else if (pull > 43 && pull < 48)
                pulls[3]++;
            else if (pull > 47 && pull < 60)
                pulls[4]++;
            else if (pull > 59 && pull < 100)
                pulls[5]++;
            else
                Log.e("GACHA", "UNEXPECTED RNG VALUE");

        }

    }


    public String getLastResult() { return last_result.substring(0,last_result.length() - 2); }
    public void setLast_result(String result){ this.last_result = result; }
    public double getCost_best()
    {
        return cost_best;
    }
    public double getCost_worst()
    {
        return cost_worst;
    }
    public HashMap getSSR_Servants()
    {
        return SSR_Servants;
    }
    public HashMap getSR_Servants()
    {
        return SR_Servants;
    }
    public HashMap getSSR_CEs()
    {
        return SSR_CEs;
    }

    public int getQuartz() { return quartz; }
}
