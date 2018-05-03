package com.example.owner.androidtest;

import android.util.Log;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class servant_small
{
    boolean special = false;
    String attribute;
    String imageURL;
    int ATK;
    int id;
    String servantClass;

    public servant_small(int ID)
    {
        id = ID;
        try {
            //we will concatenate the servant id part of the wiki after reading user input
            int x = ID; //servant id
            if (x == 83)  //SERVANT ID 83, 149, 151, 152 HAVE INCOMPATIBLE SPIRIT ORIGINS
                special = true;
            else if (x > 110) // NA known list only includes up to 106
                special = true;
            else
            {
                String webpage = "https://fate-go.cirnopedia.org/";
                String webpage_servant = webpage + "servant_profile.php?servant=" + x;
                setImageURL(webpage + "icons/servant_card/" + String.format("%03d", x) + "1.jpg");
                String myQuery;
                String myQueryClass;
                String myQueryATK;
                switch (x)  //this switch statement accommodates the different webpage layouts
                {
                    case 1: {
                        myQuery = "#content > a:nth-child(14) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(2) ";
                        myQueryATK= "> tr:nth-child(8) > td:nth-child(2)";
                        myQueryClass = "> tr:nth-child(2) > td:nth-child(4)";
                        break;
                    }
                    case 5: {
                        myQuery = "#content > a:nth-child(14) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(2) ";
                        myQueryATK= "> tr:nth-child(8) > td:nth-child(2)";
                        myQueryClass = "> tr:nth-child(2) > td:nth-child(4)";
                        break;
                    }
                    case 94: {
                        myQuery = "#content > a:nth-child(14) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(2) ";
                        myQueryATK= "> tr:nth-child(8) > td:nth-child(2)";
                        myQueryClass = "> tr:nth-child(2) > td:nth-child(4)";
                        break;
                    }
                    case 99: {
                        myQuery = "#content > a:nth-child(14) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(2) ";
                        myQueryATK= "> tr:nth-child(8) > td:nth-child(2)";
                        myQueryClass = "> tr:nth-child(2) > td:nth-child(4)";
                        break;
                    }
                    case 106: {
                        myQuery = "#content > a:nth-child(14) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(2) ";
                        myQueryATK= "> tr:nth-child(8) > td:nth-child(2)";
                        myQueryClass = "> tr:nth-child(2) > td:nth-child(4)";
                        break;
                    }
                    case 160: {
                        myQuery = "#content > a:nth-child(14) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(2) ";
                        myQueryATK= "> tr:nth-child(8) > td:nth-child(2)";
                        myQueryClass = "> tr:nth-child(2) > td:nth-child(4)";
                        break;
                    }
                    case 183: {
                        myQuery = "#content > a:nth-child(14) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(2) ";
                        myQueryATK= "> tr:nth-child(8) > td:nth-child(2)";
                        myQueryClass = "> tr:nth-child(2) > td:nth-child(4)";
                        break;
                    }
                    default:
                    {
                        if (x < 161) {
                            myQuery = "#content > a:nth-child(13) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(2) ";
                            myQueryATK = "> tr:nth-child(8) > td:nth-child(4)";
                            myQueryClass = "> tr:nth-child(2) > td:nth-child(4)";
                        }
                        else {
                            myQuery = "#content > a:nth-child(12) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(2) ";
                            myQueryATK = "> tr:nth-child(8) > td:nth-child(2)";
                            myQueryClass = "> tr:nth-child(2) > td:nth-child(4)";
                        }
                        break;
                    }
                }


                Document doc = Jsoup.connect(webpage_servant).get();

                Elements atk = doc.select(myQuery + myQueryATK);
                Elements atb = doc.select(".status > tbody:nth-child(2) > tr:nth-child(7) > td:nth-child(2)");
                Elements sClass = doc.select(myQuery + myQueryClass);
                setServantClass(sClass.toString().replaceAll("<[^>]*>","").trim());
                setAttribute(atb.toString().replaceAll("<[^>]*>","").trim()); //Star, Man, etc.
                setATK(Integer.parseInt(atk.toString().replaceAll("<[^>]*>", "").trim()));

            }

        }
        catch (IOException e)
        {
            Log.d("SERVANT", "The IOException");
            System.out.println("Error " + e.getMessage());
        }

    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public void setATK(int ATK) {
        this.ATK = ATK;
    }

    public int getATK() {
        return ATK;
    }

    public String getAttribute() {
        if(special)
            return "INVALID";
        else
            return attribute;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public void setServantClass(String servantClass) {
        this.servantClass = servantClass;
    }

    public String getServantClass() {
        return servantClass;
    }

    public String getImageURL() {
        return imageURL;
    }
}
