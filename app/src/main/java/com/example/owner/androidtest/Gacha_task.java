package com.example.owner.androidtest;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Button;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Gacha_task extends AsyncTask<Gacha, Void, Void>
{
    Gacha myGacha;


    @Override
    public Void doInBackground(Gacha ... gachas)
    {
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        String result = "";
        String name_tidy = "";
        String theQuery = "";
        myGacha = gachas[0];
        try {
            Document ServantList = Jsoup.connect("https://fate-go.cirnopedia.org/servant_all.php#nav").get();
            Document CEList = Jsoup.connect("https://fate-go.cirnopedia.org/craft_essence.php?JP=0").get();
            Elements name;
            //Elements Servant = ServantList.select("theQuery");
            //Elements CE = CEList.select(theQuery);
            //String output = CE.toString().replaceAll("<[^>]*>", "").replaceAll("/[一-龠]+|[ぁ-ゔ]+|[ァ-ヴー]+|[一-龯]+|[ａ-ｚＡ-Ｚ０-９]+[々〆〤]+/u","");


            for (int i = 0; i < 6; i++) //determine what was pulled from rarities
            {
                switch (i) {
                    case 0: //SSR Servants
                    {
                        for (int j = 0; j < myGacha.pulls[i]; j++) {
                            myGacha.card_id = myGacha.valid5Servants[myGacha.rand.nextInt(myGacha.valid5Servants.length)];
                            theQuery = "[href=servant_profile.php?servant=" + String.format("%03d", myGacha.card_id) + "]";
                            name = ServantList.select(theQuery);
                            name_tidy = name.toString().replaceAll("<a href.+<br>","").replaceAll("</a>","").replaceAll("amp;","");
                            if(myGacha.SSR_Servants.containsKey(name_tidy.trim()))
                                myGacha.SSR_Servants.put(name_tidy.trim(), (int)myGacha.SSR_Servants.get(name_tidy.trim())+1);
                            else
                                myGacha.SSR_Servants.put(name_tidy.trim(), 1);
                            result += name_tidy.trim() + ", ";
                        }
                        myGacha.pulls[i] = 0;
                        break;
                    }
                    case 1: //SR Servants
                    {
                        for (int j = 0; j < myGacha.pulls[i]; j++) {
                            myGacha.card_id = myGacha.valid4Servants[myGacha.rand.nextInt(myGacha.valid4Servants.length)];
                            theQuery = "[href=servant_profile.php?servant=" + String.format("%03d", myGacha.card_id) + "]";
                            name = ServantList.select(theQuery);
                            name_tidy = name.toString().replaceAll("<a href.+<br>","").replaceAll("</a>","").replaceAll("amp;","");
                            if(myGacha.SR_Servants.containsKey(name_tidy.trim()))
                                myGacha.SR_Servants.put(name_tidy.trim(), (int)myGacha.SR_Servants.get(name_tidy.trim())+1);
                            else
                                myGacha.SR_Servants.put(name_tidy.trim(), 1);
                            result += name_tidy.trim() + ", ";
                        }
                        myGacha.pulls[i] = 0;
                        break;
                    }
                    case 2: //R Servants
                    {
                        for (int j = 0; j < myGacha.pulls[i]; j++) {
                            myGacha.card_id = myGacha.valid3Servants[myGacha.rand.nextInt(myGacha.valid3Servants.length)];
                            theQuery = "[href=servant_profile.php?servant=" + String.format("%03d", myGacha.card_id) + "]";
                            name = ServantList.select(theQuery);
                            name_tidy = name.toString().replaceAll("<a href.+<br>","").replaceAll("</a>","").replaceAll("amp;","");
                            result += name_tidy.trim() + ", ";

                        }
                        myGacha.pulls[i] = 0;
                        break;
                    }
                    case 3: //SSR CE
                    {
                        for (int j = 0; j < myGacha.pulls[i]; j++) {

                            myGacha.card_id = myGacha.valid5CEs[myGacha.rand.nextInt(myGacha.valid5CEs.length)];
                            theQuery = "[href=craft_essence_profile.php?essence=" + String.format("%03d", myGacha.card_id) + "#nav]";
                            name = CEList.select(theQuery);
                            name_tidy = name.toString().replaceAll("><font.+<br","").replaceAll("</a>","").replaceAll("<a class=.+>","").replaceAll("amp;","");
                            if(myGacha.SSR_CEs.containsKey(name_tidy.trim()))
                                myGacha.SSR_CEs.put(name_tidy.trim(), (int)myGacha.SSR_CEs.get(name_tidy.trim())+1);
                            else
                                myGacha.SSR_CEs.put(name_tidy.trim(), 1);
                            result += name_tidy.trim() + ", ";
                        }
                        myGacha.pulls[i] = 0;
                        break;
                    }
                    case 4: //SR CE
                    {
                        for (int j = 0; j < myGacha.pulls[i]; j++) {
                            myGacha.card_id = myGacha.valid4CEs[myGacha.rand.nextInt(myGacha.valid4CEs.length)];
                            theQuery = "[href=craft_essence_profile.php?essence=" + String.format("%03d", myGacha.card_id) + "#nav]";
                            name = CEList.select(theQuery);
                            name_tidy = name.toString().replaceAll("><font.+<br","").replaceAll("</a>","").replaceAll("<a class=.+>","").replaceAll("amp;","");
                            result += name_tidy.trim() + ", ";
                        }
                        myGacha.pulls[i] = 0;
                        break;
                    }
                    case 5: //R CE
                    {
                        for (int j = 0; j < myGacha.pulls[i]; j++) {
                            myGacha.card_id = myGacha.valid3CEs[myGacha.rand.nextInt(myGacha.valid3CEs.length)];
                            theQuery = "[href=craft_essence_profile.php?essence=" + String.format("%03d", myGacha.card_id) + "#nav]";
                            name = CEList.select(theQuery);
                            name_tidy = name.toString().replaceAll("><font.+<br","").replaceAll("</a>","").replaceAll("<a class=.+>","").replaceAll("amp;","");
                            result += name_tidy.trim() + ", ";
                        }
                        myGacha.pulls[i] = 0;
                        break;
                    }
                }
            }
        }
        catch (IOException e)
        {
            Log.d("GACHA_CARDS", "The IOException: " + e.getMessage());
        }
        myGacha.setLast_result(result);

        return null;
    }
    @Override
    public void onPostExecute(Void result)
    {
        myGacha.TV3.setText(myGacha.getLastResult());
        String list;
        //if(myGacha.getSSR_Servants().isEmpty() && myGacha.getSR_Servants().isEmpty())
          //  list = "";
        //else
            list = "5★ & 4★ Servants\n";

        list =  list + myGacha.getSSR_Servants().toString().replaceAll("[{}]","").replaceAll(",","\n").replaceAll("="," x");
        //myGacha.TV1.setText(list + '\n');
        list = list + '\n' + myGacha.getSR_Servants().toString().replaceAll("[{}]","").replaceAll(",","\n").replaceAll("="," x");
        myGacha.TV1.setText(list);
        //if(myGacha.getSSR_CEs().isEmpty())
        //    list = "";
        //else
            list = "5★ Craft Essences\n";
        list =  list + myGacha.getSSR_CEs().toString().replaceAll("[{}]","").replaceAll(",","\n").replaceAll("="," x");
        myGacha.TV2.setText(list + '\n');
        myGacha.bar.setMax(100);
        myGacha.TV4.setText( "Quartz spent: "+ myGacha.getQuartz() );
        myGacha.TV5.setText( "Money spent: $" + String.format("%2.2f",myGacha.getCost_best()) );
        myGacha.theButton.setEnabled (true);
    }
}
