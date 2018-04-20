package com.example.owner.androidtest;

import android.util.Log;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Gacha
{
    Random rand = new Random();
    int[] pulls = new int[6]; //0,1,2 are servants SSR -> R, 3,4,5 are CEs SSR -> R
    double cost_best = 0.00;
    double cost_worst = 0.00;
    int quartz = 0;
    int card_id;
    String last_result;
    ArrayList<String> SSR_Servants = new ArrayList<>();
    ArrayList<String> SR_Servants = new ArrayList<>();
    //ArrayList<String> R_Servants = new ArrayList<>();
    ArrayList<String> SSR_CEs = new ArrayList<>();
    //ArrayList<String> SR_CEs = new ArrayList<>();
    //ArrayList<String> R_CEs = new ArrayList<>();
    int[] valid5CEs = {31,32,33,34,35,40,48,57,58,67,75,97,175,185,188};
    int[] valid4CEs = {21,22,23,24,25,26,27,28,29,30,38,39,47,56,66,73,74,98,176,186};
    int[] valid3CEs = {49,55,65,72,89,90,91,92,93,94,95,96,187};
    int[] valid5Servants = {2,8,37,52,59,60,62,65,75,76,77,84,85,97,98,99,106};
    int[] valid4Servants = {3,5,6,10,11,14,18,29,30,41,46,47,48,58,66,67,74,78,82,87,89,94,100,101,102,103,109};
    int[] valid3Servants = {7,9,13,15,17,20,22,23,26,27,28,31,32,35,38,42,49,55,56,63,64,71,72,79,80,81,95,104,105,110};

    public void tenPull()
    {
        last_result = "";
        quartz +=30;
        cost_best += quartz * .57;
        cost_worst = quartz;
        for(int i = 0; i < 10; i++)
        {
            int pull = rand.nextInt(100);
            if(pull == 0)
                pulls[0]++;
            else if(pull > 0 && pull < 4)
                pulls[1]++;
            else if(pull > 3 && pull < 44)
                pulls[2]++;
            else if(pull > 43 && pull < 48)
                pulls[3]++;
            else if(pull > 47 && pull < 60)
                pulls[4]++;
            else if(pull > 59 && pull < 100)
                pulls[5]++;
            else
                Log.e("GACHA","UNEXPECTED RNG VALUE");

        }
        String theQuery = "";
        try
        {
            Document ServantList = Jsoup.connect("https://fate-go.cirnopedia.org/servant_all.php#nav").get();
            Document CEList = Jsoup.connect("https://fate-go.cirnopedia.org/craft_essence.php?JP=0").get();
            Elements name;
            //Elements Servant = ServantList.select("theQuery");
            //Elements CE = CEList.select(theQuery);
            //String output = CE.toString().replaceAll("<[^>]*>", "").replaceAll("/[一-龠]+|[ぁ-ゔ]+|[ァ-ヴー]+|[一-龯]+|[ａ-ｚＡ-Ｚ０-９]+[々〆〤]+/u","");
            String name_tidy = "";
            for(int i = 0; i<6; i++) //determine what was pulled from rarities
            {
                switch (i)
                {
                    case 0: //SSR Servants
                    {
                        for (int j = 0; j < pulls[i]; j++)
                        {
                            card_id = valid5Servants[rand.nextInt(valid5Servants.length)];
                            theQuery = "[href=servant_profile.php?servant=" + String.format("%03d",card_id) + "]";
                            name = ServantList.select(theQuery);
                            name_tidy = name.toString().replaceAll("<[^>]*>", "").replaceAll("/[一-龠]+|[ぁ-ゔ]+|[ァ-ヴー]+|[一-龯]+|[ａ-ｚＡ-Ｚ０-９]+[々〆〤]+/u","");
                            name_tidy = name_tidy.replaceAll("[〕〔Ⅱ･＝々Ｘ]","");
                            SSR_Servants.add(name_tidy.trim());
                            last_result +=name_tidy.trim() + "\n";
                        }
                    }
                    case 1: //SR Servants
                    {
                        for (int j = 0; j < pulls[i]; j++)
                        {
                            card_id = valid4Servants[rand.nextInt(valid4Servants.length)];
                            theQuery = "[href=servant_profile.php?servant=" + String.format("%03d",card_id) + "]";
                            name = ServantList.select(theQuery);
                            name_tidy = name.toString().replaceAll("<[^>]*>", "").replaceAll("/[一-龠]+|[ぁ-ゔ]+|[ァ-ヴー]+|[一-龯]+|[ａ-ｚＡ-Ｚ０-９]+[々〆〤]+/u","");
                            name_tidy = name_tidy.replaceAll("[〕〔Ⅱ･＝々Ｘ]","");
                            SR_Servants.add(name_tidy.trim());
                            last_result +=name_tidy.trim() + "\n";
                        }
                    }
                    case 2: //R Servants
                    {
                        for (int j = 0; j < pulls[i]; j++)
                        {
                            card_id = valid3Servants[rand.nextInt(valid3Servants.length)];
                            theQuery = "[href=servant_profile.php?servant=" + String.format("%03d",card_id) + "]";
                            name = ServantList.select(theQuery);
                            name_tidy = name.toString().replaceAll("<[^>]*>", "").replaceAll("/[一-龠]+|[ぁ-ゔ]+|[ァ-ヴー]+|[一-龯]+|[ａ-ｚＡ-Ｚ０-９]+[々〆〤]+/u","");
                            name_tidy = name_tidy.replaceAll("[〕〔Ⅱ･＝々Ｘ]","");
                            last_result +=name_tidy.trim() + "\n";

                        }
                    }
                    case 3: //SSR CE
                    {
                        for (int j = 0; j < pulls[i]; j++)
                        {

                            card_id = valid5CEs[rand.nextInt(valid5CEs.length)];
                            theQuery = "[href=craft_essence_profile.php?essence=" + String.format("%03d", card_id) + "#nav]";
                            name = CEList.select(theQuery);
                            name_tidy = name.toString().replaceAll("<[^>]*>", "").replaceAll("/[一-龠]+|[ぁ-ゔ]+|[ァ-ヴー]+|[一-龯]+|[ａ-ｚＡ-Ｚ０-９]+[々〆〤]+/u","");
                            name_tidy = name_tidy.replaceAll("[〕〔Ⅱ･＝々Ｘ]","");
                            SSR_CEs.add(name_tidy.trim());
                            last_result +=name_tidy.trim() + "\n";
                        }
                    }
                    case 4: //SR CE
                    {
                        for (int j = 0; j < pulls[i]; j++)
                        {
                            card_id = valid4CEs[rand.nextInt(valid4CEs.length)];
                            theQuery = "[href=craft_essence_profile.php?essence=" + String.format("%03d", card_id) + "#nav]";
                            name = CEList.select(theQuery);
                            name_tidy = name.toString().replaceAll("<[^>]*>", "").replaceAll("/[一-龠]+|[ぁ-ゔ]+|[ァ-ヴー]+|[一-龯]+|[ａ-ｚＡ-Ｚ０-９]+[々〆〤]+/u","");
                            name_tidy = name_tidy.replaceAll("[〕〔Ⅱ･＝々Ｘ]","");
                            last_result +=name_tidy.trim() + "\n";
                        }
                    }
                    case 5: //R CE
                    {
                        for (int j = 0; j < pulls[i]; j++)
                        {
                            card_id = valid3CEs[rand.nextInt(valid3CEs.length)];
                            theQuery = "[href=craft_essence_profile.php?essence=" + String.format("%03d", card_id) + "#nav]";
                            name = CEList.select(theQuery);
                            name_tidy = name.toString().replaceAll("<[^>]*>", "").replaceAll("/[一-龠]+|[ぁ-ゔ]+|[ァ-ヴー]+|[一-龯]+|[ａ-ｚＡ-Ｚ０-９]+[々〆〤]+/u","");
                            name_tidy = name_tidy.replaceAll("[〕〔Ⅱ･＝々Ｘ]","");
                            last_result +=name_tidy.trim() + "\n";
                        }
                    }
                }
            }
        }
        catch(IOException e)
        {
            Log.d("GACHA_CARDS", "The IOException: " + e.getMessage());
        }

    }
    public String getLastResult()
    {
        return last_result;
    }
    public double getCost_best()
    {
        return cost_best;
    }
    public double getCost_worst()
    {
        return cost_worst;
    }
    public ArrayList<String> getSSR_Servants()
    {
        return SSR_Servants;
    }
    public ArrayList<String> getSR_Servants()
    {
        return SR_Servants;
    }
    public ArrayList<String> getSSR_CEs()
    {
        return SSR_CEs;
    }
}
