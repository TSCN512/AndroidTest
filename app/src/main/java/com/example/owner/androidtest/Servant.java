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
    String imageURL;
    public Servant(int ID)
    {
        String[] myArray = {"Name: ","Alias: ","Class: ", "ID: ", "Rarity: ", "Cost: ", "Max Level Cap: ", "Starting ATK: ", "Starting HP: ", "Max Level ATK: ", "Max Level HP: ", "Level 100 ATK: ","Level 100 HP: ","",""};
        //myArray[0] = "READY";
        try {
            //we will concatenate the servant id part of the wiki after reading user input
            int x = ID; //servant id
            if (x == 83)  //SERVANT ID 83, 149, 151, 152 HAVE INCOMPATIBLE SPIRIT ORIGINS
            {
                special = true;
                setSpecialMsg("CLASS: GRAND CASTER  \nNAME: KING SOLOMON, KING OF MAGES\nREMAINING SPIRIT GRAPH DATA INCOMPATIBLE WITH CHALDEA PROTOCOLS");
            }
            else if (x > 110) // NA known list only includes up to 106
            {
                special = true;
                setSpecialMsg("SPIRIT ORIGIN UNDISCOVERED BY CHALDEA NORTH AMERICAN BRANCH");
            }
            else
            {
                String webpage = "https://fate-go.cirnopedia.org/";
                String webpage_servant = webpage + "servant_profile.php?servant=" + x;
                setImageURL(webpage + "icons/servant_card/" + String.format("%03d", x) + "1.jpg");
                String myQuery;
                switch (x)  //this switch statement accommodates the different webpage layouts
                {
                    case 1: {
                        myQuery = "#content > a:nth-child(14) > div:nth-child(1) > table:nth-child(1)";
                        break;
                    }
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


                Document doc = Jsoup.connect(webpage_servant).get();

                Elements links = doc.select(myQuery);
                //traits grabbing happens here
                Elements link2 = doc.select(".status > tbody:nth-child(2) > tr:nth-child(8) > td:nth-child(2)");
                String traits = link2.toString().replaceAll("<[^>]*>","");
                setTraits(traits);
                //IMG grabbbing here
               //Elements portrait = doc.select("a.fancybox:nth-child(8) > div:nth-child(1)");

                String atk = links.toString();//.substring(links.toString().indexOf("ATK Lv.1"));
                String atk2 = links.toString();
                if(!atk2.contains("★★★★★") && !atk2.contains("★★★★") && !atk2.contains("★★★"))
                {
                    if (atk2.contains("★★"))
                        atk2 = atk2.replace("★★", "★★ UC");
                    else if (atk2.contains("★"))
                        atk2 = atk2.replace("★", "★ C");
                }
                atk2 = atk2.replace("---", "Zero Star");
                atk2 = atk2.replaceAll("<[^>]*>", "").replaceAll("\n[^a-zA-Z_0-9｢?]+\n", "\n"); //servant 91 has a unique name beginning with ｢
                atk2 = atk2.replaceFirst("\n.*\n", "\n");
                atk2 = atk2.replaceAll("\n.*\n", "\n");
                atk2 = atk2.replaceFirst("\n", "");

                String myArray2[] = atk2.split("\n");
                for (int j = 0; j < myArray.length; j++)
                {
                    if(j==1)
                        myArray[j] += myArray2[j].split(">")[myArray2[j].split(">").length-1].trim(); //dirty looking
                    else if(x==107 && j==4)
                            myArray[j] += "---";
                    else
                        myArray[j] += myArray2[j].trim();
                    if (x == 1 && j == 1) //Mash has fused with an unknown heroic spirit, true name unknown
                        myArray[j] = "TRUE NAME UNKNOWN";
                }
                //System.out.println(myArray[3]);

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

    public void setImageURL(String loc)
    {
        this.imageURL = loc;
    }
    public String getImageURL()
    {
        return this.imageURL;
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
            for (int i= 0; i<stats.length-2; i++)
                info += stats[i] + '\n';
            info+= traits;
            info = info.trim();
            return info;
        }
        else
            return specialMsg;
    }
}
