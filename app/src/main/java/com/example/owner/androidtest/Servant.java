package com.example.owner.androidtest;

import android.util.Log;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Servant
{
    boolean special = false;
    String[] stats = new String[16];
    String traits;
    String specialMsg;

    public Servant(int ID)
    {
        String[] myArray = new String[16];
        //myArray[0] = "READY";
        try {
            //we will concatenate the servant id part of the wiki after reading user input
            int x = ID; //servant id
            String webpage = "https://fate-go.cirnopedia.org/servant_profile.php?servant=" + x;
            String myQuery;
            switch (x)  //this switch statement accommodates the different webpage layouts
            {
                case 5: {
                    myQuery = "#content > a:nth-child(14) > div:nth-child(1) > table:nth-child(1)";
                    break;
                }
                case 94: {
                    myQuery = "#content > a:nth-child(14) > div:nth-child(1) > table:nth-child(1)";
                    break;
                }
                case 99: {
                    myQuery = "#content > a:nth-child(14) > div:nth-child(1) > table:nth-child(1)";
                    break;
                }
                case 106: {
                    myQuery = "#content > a:nth-child(14) > div:nth-child(1) > table:nth-child(1)";
                    break;
                }
                case 183: {
                    myQuery = "#content > a:nth-child(13) > div:nth-child(1) > table:nth-child(1)";
                    break;
                }
                default: {
                    if (x < 161)
                        myQuery = "#content > a:nth-child(13) > div:nth-child(1) > table:nth-child(1)";
                    else
                        myQuery = "#content > a:nth-child(12) > div:nth-child(1) > table:nth-child(1)";
                    break;
                }
            }


            Document doc = Jsoup.connect(webpage).get();
            String title = doc.title();
            System.out.println(title);
            Elements links = doc.select(myQuery);
            String atk = links.toString();//.substring(links.toString().indexOf("ATK Lv.1"));
            String atk2 = links.toString();
            if(!atk2.contains("★★★★★") && !atk2.contains("★★★★") && !atk2.contains("★★★"))
            {
                if (atk2.contains("★★"))
                    atk2 = atk2.replace("★★", "★★ UC");
                else if (atk2.contains("★"))
                    atk2 = atk2.replace("★", "★ C");
            }

            atk2 = atk2.replaceAll("<[^>]*>", "").replaceAll("\n[^a-zA-Z_0-9｢?]+\n", "\n"); //servant 91 has a unique name beginning with ｢
            atk2 = atk2.replaceFirst("\n.*\n", "\n");
            atk2 = atk2.replaceAll("\n.*\n", "\n");
            atk2 = atk2.replaceFirst("\n", "");

            myArray = atk2.split("\n");
            for (int j = 0; j < myArray.length; j++)
            {
                if (x == 1 && j == 1) //Mash has fused with an unknown heroic spirit, true name unknown
                    myArray[j] = "TRUE NAME UNKNOWN";
                else
                    myArray[j] = myArray[j].trim();
            }
            //System.out.println(myArray[3]);
            if (x == 83)  //SERVANT ID 83, 149, 151, 152 HAVE INCOMPATIBLE SPIRIT ORIGINS
            {
                special = true;
                setSpecialMsg("UNREADABLE SPIRIT ORIGIN, KING OF MAGES DETECTED");
            }
            else if (x > 106) // NA known list only includes up to 106
            {
                special = true;
                setSpecialMsg("SPIRIT ORIGIN UNDISCOVERED BY CHALDEA NORTH AMERICAN BRANCH");
            }
            else
            {
                stats=myArray;
            }

            //start getting traits here
        }
        catch (IOException e)
        {
            Log.d("SERVANT", "The IOException");
            System.out.println("Error " + e.getMessage());
        }

    }

    public void setSpecialMsg(String specialMsg)
    {
        this.specialMsg = specialMsg;
    }

    public void setTraits(String traits)
    {
        this.traits = traits;
    }

    @Override
    public String toString()
    {
        if(!special)
        {
            String info = "";
            for (String value : stats)
                info += value + '\n';
            info = info.trim();
            return info;
        }
        else
            return specialMsg;
    }
}
