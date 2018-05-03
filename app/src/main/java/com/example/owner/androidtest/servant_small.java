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
    int cost;
    String servantClass;

    public servant_small(int ID)
    {
        id = ID;
        String myQuery;
        String myQueryClass;
        String myQueryATK;
        String myQueryCost;
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

                switch (x)  //this switch statement accommodates the different webpage layouts
                {
                    case 1: {
                        myQuery = "#content > a:nth-child(14) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(2) ";
                        myQueryATK= "> tr:nth-child(8) > td:nth-child(2)";
                        myQueryClass = "> tr:nth-child(2) > td:nth-child(4)";
                        myQueryCost = "> tr:nth-child(5) > td:nth-child(2)";
                        break;
                    }
                    case 5: {
                        myQuery = "#content > a:nth-child(14) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(2) ";
                        myQueryATK= "> tr:nth-child(8) > td:nth-child(2)";
                        myQueryClass = "> tr:nth-child(2) > td:nth-child(4)";
                        myQueryCost = "> tr:nth-child(5) > td:nth-child(2)";
                        break;
                    }
                    case 94: {
                        myQuery = "#content > a:nth-child(14) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(2) ";
                        myQueryATK= "> tr:nth-child(8) > td:nth-child(2)";
                        myQueryClass = "> tr:nth-child(2) > td:nth-child(4)";
                        myQueryCost = "> tr:nth-child(5) > td:nth-child(2)";
                        break;
                    }
                    case 99: {
                        myQuery = "#content > a:nth-child(14) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(2) ";
                        myQueryATK= "> tr:nth-child(8) > td:nth-child(2)";
                        myQueryClass = "> tr:nth-child(2) > td:nth-child(4)";
                        myQueryCost = "> tr:nth-child(5) > td:nth-child(2)";
                        break;
                    }
                    case 106: {
                        myQuery = "#content > a:nth-child(14) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(2) ";
                        myQueryATK= "> tr:nth-child(8) > td:nth-child(2)";
                        myQueryClass = "> tr:nth-child(2) > td:nth-child(4)";
                        myQueryCost = "> tr:nth-child(5) > td:nth-child(2)";
                        break;
                    }
                    case 160: {
                        myQuery = "#content > a:nth-child(14) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(2) ";
                        myQueryATK= "> tr:nth-child(8) > td:nth-child(2)";
                        myQueryClass = "> tr:nth-child(2) > td:nth-child(4)";
                        myQueryCost = "> tr:nth-child(5) > td:nth-child(2)";
                        break;
                    }
                    case 183: {
                        myQuery = "#content > a:nth-child(14) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(2) ";
                        myQueryATK= "> tr:nth-child(8) > td:nth-child(2)";
                        myQueryClass = "> tr:nth-child(2) > td:nth-child(4)";
                        myQueryCost = "> tr:nth-child(5) > td:nth-child(2)";
                        break;
                    }
                    default:
                    {
                        if (x < 161) {
                            myQuery = "#content > a:nth-child(13) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(2) ";
                            myQueryATK = "> tr:nth-child(8) > td:nth-child(4)";
                            myQueryClass = "> tr:nth-child(2) > td:nth-child(4)";
                            myQueryCost = "> tr:nth-child(5) > td:nth-child(2)";
                        }
                        else {
                            myQuery = "#content > a:nth-child(12) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(2) ";
                            myQueryATK = "> tr:nth-child(8) > td:nth-child(2)";
                            myQueryClass = "> tr:nth-child(2) > td:nth-child(4)";
                            myQueryCost = "> tr:nth-child(5) > td:nth-child(2)";
                        }
                        break;
                    }
                }


                Document doc = Jsoup.connect(webpage_servant).get();

                Elements atk = doc.select(myQuery + myQueryATK);
                Elements atb = doc.select(".status > tbody:nth-child(2) > tr:nth-child(7) > td:nth-child(2)");
                Elements sClass = doc.select(myQuery + myQueryClass);
                Elements cost = doc.select(myQuery + myQueryCost);
                setServantClass(sClass.toString().replaceAll("<[^>]*>","").replaceAll(",","").trim());
                setAttribute(atb.toString().replaceAll("<[^>]*>","").replaceAll(",","").trim()); //Star, Man, etc.
                setATK(Integer.parseInt(atk.toString().replaceAll("<[^>]*>", "").replaceAll(",","").trim()));
                setCost(cost.toString().replaceAll("<[^>]*>","").trim());


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

    public boolean isSpecial() {
        return special;
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

    public void setCost(String cost) {
        this.cost = Integer.parseInt(cost);
    }
    public String classIcon()
    {
        String location = "";
        if (getServantClass().equalsIgnoreCase("Saber"))
            location += "saber";
        else if (getServantClass().equalsIgnoreCase( "Archer"))
            location += "archer";
        else if (getServantClass().equalsIgnoreCase("Lancer"))
            location += "lancer";
        else if (getServantClass().equalsIgnoreCase( "Caster"))
            location += "caster";
        else if (getServantClass().equalsIgnoreCase("Rider"))
            location += "rider";
        else if (getServantClass().equalsIgnoreCase("Assassin"))
            location += "assassin";
        else if (getServantClass().equalsIgnoreCase( "Berserker"))
            location += "berserker";
        else if (getServantClass().equalsIgnoreCase( "Ruler"))
            location += "ruler";
        else if (getServantClass().equalsIgnoreCase( "Avenger"))
            location += "berserker";
        if(!getServantClass().equalsIgnoreCase("Shielder"))
        {
            switch (getRarity()) {
                case 0: {
                    location += "0";
                    break;
                }
                case 1: {
                    location += "1";
                    break;
                }
                case 2: {
                    location += "1";
                    break;
                }
                case 3: {
                    location += "3";
                    break;
                }
                case 4: {
                    location += "5";
                    break;
                }
                case 5: {
                    location += "5";
                    break;
                }
            }
        }
        else
            location = "shield";
        return location;
    }
    public int getRarity() {
        switch (cost)
        {
            case 3: {
                return 1;
            }
            case 4: {
                if(getServantClass()=="Avenger")
                    return 0;
                else
                    return 2;
            }
            case 7: {
                return 3;

            }
            case 12: {
                return 4;

            }
            case 16: {
                return 5;

            }
            default: {
                return 1000;

            }
        }
    }
}
