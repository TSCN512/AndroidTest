package com.example.owner.androidtest;

import android.os.AsyncTask;
import android.util.Log;
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
                        for (int j = 0; j < gachas[0].pulls[i]; j++) {
                            gachas[0].card_id = gachas[0].valid5Servants[gachas[0].rand.nextInt(gachas[0].valid5Servants.length)];
                            theQuery = "[href=servant_profile.php?servant=" + String.format("%03d", gachas[0].card_id) + "]";
                            name = ServantList.select(theQuery);
                            name_tidy = name.toString().replaceAll("<[^>]*>", "").replaceAll("/[一-龠]+|[ぁ-ゔ]+|[ァ-ヴー]+|[一-龯]+|[ａ-ｚＡ-Ｚ０-９]+[々〆〤]+/u", "");
                            name_tidy = name_tidy.replaceAll("[〕〔Ⅱ･＝々Ｘ]", "");
                            gachas[0].SSR_Servants.add(name_tidy.trim());
                            result += name_tidy.trim() + ", ";
                        }
                        gachas[0].pulls[i] = 0;
                        break;
                    }
                    case 1: //SR Servants
                    {
                        for (int j = 0; j < gachas[0].pulls[i]; j++) {
                            gachas[0].card_id = gachas[0].valid4Servants[gachas[0].rand.nextInt(gachas[0].valid4Servants.length)];
                            theQuery = "[href=servant_profile.php?servant=" + String.format("%03d", gachas[0].card_id) + "]";
                            name = ServantList.select(theQuery);
                            name_tidy = name.toString().replaceAll("<[^>]*>", "").replaceAll("/[一-龠]+|[ぁ-ゔ]+|[ァ-ヴー]+|[一-龯]+|[ａ-ｚＡ-Ｚ０-９]+[々〆〤]+/u", "");
                            name_tidy = name_tidy.replaceAll("[〕〔Ⅱ･＝々Ｘ]", "");
                            gachas[0].SR_Servants.add(name_tidy.trim());
                            result += name_tidy.trim() + ", ";
                        }
                        gachas[0].pulls[i] = 0;
                        break;
                    }
                    case 2: //R Servants
                    {
                        for (int j = 0; j < gachas[0].pulls[i]; j++) {
                            gachas[0].card_id = gachas[0].valid3Servants[gachas[0].rand.nextInt(gachas[0].valid3Servants.length)];
                            theQuery = "[href=servant_profile.php?servant=" + String.format("%03d", gachas[0].card_id) + "]";
                            name = ServantList.select(theQuery);
                            name_tidy = name.toString().replaceAll("<[^>]*>", "").replaceAll("/[一-龠]+|[ぁ-ゔ]+|[ァ-ヴー]+|[一-龯]+|[ａ-ｚＡ-Ｚ０-９]+[々〆〤]+/u", "");
                            name_tidy = name_tidy.replaceAll("[〕〔Ⅱ･＝々Ｘ]", "");
                            result += name_tidy.trim() + ", ";

                        }
                        gachas[0].pulls[i] = 0;
                        break;
                    }
                    case 3: //SSR CE
                    {
                        for (int j = 0; j < gachas[0].pulls[i]; j++) {

                            gachas[0].card_id = gachas[0].valid5CEs[gachas[0].rand.nextInt(gachas[0].valid5CEs.length)];
                            theQuery = "[href=craft_essence_profile.php?essence=" + String.format("%03d", gachas[0].card_id) + "#nav]";
                            name = CEList.select(theQuery);
                            name_tidy = name.toString().replaceAll("<[^>]*>", "").replaceAll("/[一-龠]+|[ぁ-ゔ]+|[ァ-ヴー]+|[一-龯]+|[ａ-ｚＡ-Ｚ０-９]+[々〆〤]+/u", "");
                            name_tidy = name_tidy.replaceAll("[〕〔Ⅱ･＝々Ｘ]", "");
                            gachas[0].SSR_CEs.add(name_tidy.trim());
                            result += name_tidy.trim() + ", ";
                        }
                        gachas[0].pulls[i] = 0;
                        break;
                    }
                    case 4: //SR CE
                    {
                        for (int j = 0; j < gachas[0].pulls[i]; j++) {
                            gachas[0].card_id = gachas[0].valid4CEs[gachas[0].rand.nextInt(gachas[0].valid4CEs.length)];
                            theQuery = "[href=craft_essence_profile.php?essence=" + String.format("%03d", gachas[0].card_id) + "#nav]";
                            name = CEList.select(theQuery);
                            name_tidy = name.toString().replaceAll("<[^>]*>", "").replaceAll("/[一-龠]+|[ぁ-ゔ]+|[ァ-ヴー]+|[一-龯]+|[ａ-ｚＡ-Ｚ０-９]+[々〆〤]+/u", "");
                            name_tidy = name_tidy.replaceAll("[〕〔Ⅱ･＝々Ｘ]", "");
                            result += name_tidy.trim() + ", ";
                        }
                        gachas[0].pulls[i] = 0;
                        break;
                    }
                    case 5: //R CE
                    {
                        for (int j = 0; j < gachas[0].pulls[i]; j++) {
                            gachas[0].card_id = gachas[0].valid3CEs[gachas[0].rand.nextInt(gachas[0].valid3CEs.length)];
                            theQuery = "[href=craft_essence_profile.php?essence=" + String.format("%03d", gachas[0].card_id) + "#nav]";
                            name = CEList.select(theQuery);
                            name_tidy = name.toString().replaceAll("<[^>]*>", "").replaceAll("/[一-龠]+|[ぁ-ゔ]+|[ァ-ヴー]+|[一-龯]+|[ａ-ｚＡ-Ｚ０-９]+[々〆〤]+/u", "");
                            name_tidy = name_tidy.replaceAll("[〕〔Ⅱ･＝々Ｘ]", "");
                            result += name_tidy.trim() + ", ";
                        }
                        gachas[0].pulls[i] = 0;
                        break;
                    }
                }
            }
        }
        catch (IOException e)
        {
            Log.d("GACHA_CARDS", "The IOException: " + e.getMessage());
        }
        gachas[0].setLast_result(result);
        myGacha = gachas[0];
        return null;
    }
    @Override
    public void onPostExecute(Void result)
    {
        myGacha.TV3.setText(myGacha.getLastResult());
        for (String value : myGacha.getSSR_Servants())
        {
            myGacha.TV1.append(value + '\n');
        }
        for(String value : myGacha.getSR_Servants())
        {
            myGacha.TV1.append(value + '\n');
        }
        for(String value : myGacha.getSSR_CEs())
        {
            myGacha.TV2.append(value + '\n');
        }
    }
}
