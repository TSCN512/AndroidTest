package com.example.owner.androidtest;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.*;

import java.util.Random;
import java.util.Stack;

public class dmg_calculator extends AppCompatActivity{
    String monsterUrl = "";
    String monsterC = "";
    String monsterA = "";
    Stack cards = new Stack();
    Random rand = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_dmg_calculator);
        final String[]options = {"Skeleton (Saber)", "Skeleton (Archer)", "Skeleton (Lancer)", "French Soldier (Saber)",
                "French Soldier (Lancer)", "Roman Soldier (Saber)", "Roman Soldier (Archer)", "Roman Soldier (Lancer)",
                "Pirate (Saber)", "Pirate (Archer)", "Pirate (Berserker)", "Druid", "Celtic Soldier (Saber)",
                "Celtic Soldier (Archer)", "Celtic Soldier (Lancer)", "Amazoness (Saber)", "Amazoness (Archer)",
                "Amazoness (Lancer)", "Ghost", "Wyvern", "Dragon", "Goblin (Saber)", "Goblin (Lancer)", "Goblin (Assassin)",
                "Centaur", "Chimera", "Demon", "Homunculus", "Golem", "Automata", "Helter Skelter", "Mech Infantry", "Spellbook",
                "Soul Eater", "Gazer", "Bicorn", "Spriggan", "Makhur", "Zayd", "Gozhur", "Blade-Wing Insects", "Sea Devil"};
        final Button tester = (Button) findViewById(R.id.calcStart);
        final TextView servantClass = (TextView) findViewById(R.id.servantClass);
        final ImageView servantPic = (ImageView) findViewById(R.id.servantPic);
        final TextView servantAtk = (TextView) findViewById(R.id.servantAtk2);
        final ImageView classPic = (ImageView) findViewById(R.id.class_icon);
        final EditText IDtaker = (EditText) findViewById(R.id.idTaker);
        final Spinner monsters = (Spinner)findViewById(R.id.monsterSpinner);
        final ImageView monsterPic = (ImageView) findViewById(R.id.monsterPic);
        final TextView monsterAtt = (TextView) findViewById(R.id.monsterAttribute);
        final ImageView mclassPic = (ImageView) findViewById(R.id.monsterClass);
        final TextView servantAttribute =(TextView) findViewById(R.id.servantAttribute);
        final ImageView buster = (ImageView) findViewById(R.id.busterButton);
        final ImageView arts = (ImageView) findViewById(R.id.artsButton);
        final ImageView quick = (ImageView) findViewById(R.id.quickButton);
        final Button undo = (Button) findViewById(R.id.undoButton);
        final TextView cardLog = (TextView) findViewById(R.id.cardLog);
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,options);
        IDtaker.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_CLASS_NUMBER); //block special characters
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        monsters.setAdapter(adapter);
        monsters.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int position, long id)
            {
                String monsterClass ="";
                String urlImg = "";
                switch (position)
                {
                    case 0:
                        monsterClass ="saber";
                        urlImg = "icons/enemy/enemy_009-01.png";
                        setMonsterC(monsterClass);
                        setMonsterUrl(urlImg);
                        setMonsterAttribute("Man");
                        break;
                    case 1:
                        monsterClass ="archer";
                        urlImg = "icons/enemy/enemy_009-03.png";
                        setMonsterC(monsterClass);
                        setMonsterUrl(urlImg);
                        setMonsterAttribute("Man");
                        break;
                    case 2:
                        monsterClass="lancer";
                        urlImg = "icons/enemy/enemy_009-02.png";
                        setMonsterC(monsterClass);
                        setMonsterUrl(urlImg);
                        setMonsterAttribute("Man");
                        break;
                    case 3:
                        monsterClass ="saber";
                        urlImg = "icons/enemy/enemy_011-01.png";
                        setMonsterC(monsterClass);
                        setMonsterUrl(urlImg);
                        setMonsterAttribute("Man");
                        break;
                    case 4:
                        monsterClass="lancer";
                        urlImg = "icons/enemy/enemy_011-02.png";
                        setMonsterC(monsterClass);
                        setMonsterUrl(urlImg);
                        setMonsterAttribute("Man");
                        break;
                    case 5:
                        monsterClass ="saber";
                        urlImg = "icons/enemy/enemy_019-01.png";
                        setMonsterC(monsterClass);
                        setMonsterUrl(urlImg);
                        setMonsterAttribute("Man");
                        break;
                    case 6:
                        monsterClass ="archer";
                        urlImg = "icons/enemy/enemy_019-03.png";
                        setMonsterC(monsterClass);
                        setMonsterUrl(urlImg);
                        setMonsterAttribute("Man");
                        break;
                    case 7:
                        monsterClass="lancer";
                        urlImg = "icons/enemy/enemy_019-02.png";
                        setMonsterC(monsterClass);
                        setMonsterUrl(urlImg);
                        setMonsterAttribute("Man");
                        break;
                    case 8:
                        monsterClass ="saber";
                        urlImg = "icons/enemy/enemy_037-01.png";
                        setMonsterC(monsterClass);
                        setMonsterUrl(urlImg);
                        setMonsterAttribute("Man");
                        break;
                    case 9:
                        monsterClass ="archer";
                        urlImg = "icons/enemy/enemy_037-03.png";
                        setMonsterC(monsterClass);
                        setMonsterUrl(urlImg);
                        setMonsterAttribute("Man");
                        break;
                    case 10:
                        monsterClass="berserker";
                        urlImg = "icons/enemy/enemy_037-07.png";
                        setMonsterC(monsterClass);
                        setMonsterUrl(urlImg);
                        setMonsterAttribute("Man");
                        break;
                    case 11:
                        monsterClass="caster";
                        urlImg = "icons/enemy/enemy_089-05.png";
                        setMonsterC(monsterClass);
                        setMonsterUrl(urlImg);
                        setMonsterAttribute("Man");
                        break;
                    case 12:
                        monsterClass ="saber";
                        urlImg = "icons/enemy/enemy_089-01.png";
                        setMonsterC(monsterClass);
                        setMonsterUrl(urlImg);
                        setMonsterAttribute("Man");
                        break;
                    case 13:
                        monsterClass ="archer";
                        urlImg = "icons/enemy/enemy_089-03.png";
                        setMonsterC(monsterClass);
                        setMonsterUrl(urlImg);
                        setMonsterAttribute("Man");
                        break;
                    case 14:
                        monsterClass="lancer";
                        urlImg = "icons/enemy/enemy_089-02.png";
                        setMonsterC(monsterClass);
                        setMonsterUrl(urlImg);
                        setMonsterAttribute("Man");
                        break;
                    case 15:
                        monsterClass ="saber";
                        urlImg = "icons/enemy/enemy_044.png";
                        setMonsterC(monsterClass);
                        setMonsterUrl(urlImg);
                        setMonsterAttribute("Man");
                        break;
                    case 16:
                        monsterClass ="archer";
                        urlImg = "icons/enemy/enemy_044.png";
                        setMonsterC(monsterClass);
                        setMonsterUrl(urlImg);
                        setMonsterAttribute("Man");
                        break;
                    case 17:
                        monsterClass="lancer";
                        urlImg = "icons/enemy/enemy_044.png";
                        setMonsterC(monsterClass);
                        setMonsterUrl(urlImg);
                        setMonsterAttribute("Man");
                        break;
                    case 18:
                        monsterClass="assassin";
                        urlImg = "icons/enemy/enemy_022.png";
                        setMonsterC(monsterClass);
                        setMonsterUrl(urlImg);
                        setMonsterAttribute("Sky");
                        break;
                    case 19:
                        monsterClass="rider";
                        urlImg = "icons/enemy/enemy_013.png";
                        setMonsterC(monsterClass);
                        setMonsterUrl(urlImg);
                        setMonsterAttribute("Earth");
                        break;
                    case 20:
                        monsterClass="rider";
                        urlImg = "icons/enemy/enemy_039.png";
                        setMonsterC(monsterClass);
                        setMonsterUrl(urlImg);
                        setMonsterAttribute("Earth");
                        break;
                    case 21:
                        monsterClass ="saber";
                        urlImg = "icons/enemy/enemy_036.png";
                        setMonsterC(monsterClass);
                        setMonsterUrl(urlImg);
                        setMonsterAttribute("Earth");
                        break;
                    case 22:
                        monsterClass="lancer";
                        urlImg = "icons/enemy/enemy_036.png";
                        setMonsterC(monsterClass);
                        setMonsterUrl(urlImg);
                        setMonsterAttribute("Earth");
                        break;
                    case 23:
                        monsterClass="assassin";
                        urlImg = "icons/enemy/enemy_036.png";
                        setMonsterC(monsterClass);
                        setMonsterUrl(urlImg);
                        setMonsterAttribute("Earth");
                        break;
                    case 24:
                        monsterClass="rider";
                        urlImg = "icons/enemy/enemy_062.png";
                        setMonsterC(monsterClass);
                        setMonsterUrl(urlImg);
                        setMonsterAttribute("Earth");
                        break;
                    case 25:
                        monsterClass="berserker";
                        urlImg = "icons/enemy/enemy_030.png";
                        setMonsterC(monsterClass);
                        setMonsterUrl(urlImg);
                        setMonsterAttribute("Earth");
                        break;
                    case 26:
                        monsterClass="caster";
                        urlImg = "icons/enemy/enemy_026.png";
                        setMonsterC(monsterClass);
                        setMonsterUrl(urlImg);
                        setMonsterAttribute("Sky");
                        break;
                    case 27:
                        monsterClass="lancer";
                        urlImg = "icons/enemy/enemy_041.png";
                        setMonsterC(monsterClass);
                        setMonsterUrl(urlImg);
                        setMonsterAttribute("Sky");
                        break;
                    case 28:
                        monsterClass="berserker";
                        urlImg = "icons/enemy/enemy_027.png";
                        setMonsterC(monsterClass);
                        setMonsterUrl(urlImg);
                        setMonsterAttribute("Sky");
                        break;
                    case 29:
                        monsterClass="assassin";
                        urlImg = "icons/enemy/enemy_079.png";
                        setMonsterC(monsterClass);
                        setMonsterUrl(urlImg);
                        setMonsterAttribute("Sky");
                        break;
                    case 30:
                        monsterClass="saber";
                        urlImg = "icons/enemy/enemy_082.png";
                        setMonsterC(monsterClass);
                        setMonsterUrl(urlImg);
                        setMonsterAttribute("Sky");
                        break;
                    case 31:
                        monsterClass ="archer";
                        urlImg = "icons/enemy/enemy_086.png";
                        setMonsterC(monsterClass);
                        setMonsterUrl(urlImg);
                        setMonsterAttribute("Man");
                        break;
                    case 32:
                        monsterClass="caster";
                        urlImg = "icons/enemy/enemy_073.png";
                        setMonsterC(monsterClass);
                        setMonsterUrl(urlImg);
                        setMonsterAttribute("Sky");
                        break;
                    case 33:
                        monsterClass="assassin";
                        urlImg = "icons/enemy/enemy_090.png";
                        setMonsterC(monsterClass);
                        setMonsterUrl(urlImg);
                        setMonsterAttribute("Earth");
                        break;
                    case 34:
                        monsterClass ="archer";
                        urlImg = "icons/enemy/enemy_091.png";
                        setMonsterC(monsterClass);
                        setMonsterUrl(urlImg);
                        setMonsterAttribute("Earth");
                        break;
                    case 35:
                        monsterClass="lancer";
                        urlImg = "icons/enemy/enemy_092.png";
                        setMonsterC(monsterClass);
                        setMonsterUrl(urlImg);
                        setMonsterAttribute("Earth");
                        break;
                    case 36:
                        monsterClass ="saber";
                        urlImg = "icons/enemy/enemy_093.png";
                        setMonsterC(monsterClass);
                        setMonsterUrl(urlImg);
                        setMonsterAttribute("Earth");
                        break;
                    case 37:
                        monsterClass="assassin";
                        urlImg = "icons/enemy/enemy_106.png";
                        setMonsterC(monsterClass);
                        setMonsterUrl(urlImg);
                        setMonsterAttribute("Man");
                        break;
                    case 38:
                        monsterClass="assassin";
                        urlImg = "icons/enemy/enemy_107.png";
                        setMonsterC(monsterClass);
                        setMonsterUrl(urlImg);
                        setMonsterAttribute("Man");
                        break;
                    case 39:
                        monsterClass="assassin";
                        urlImg = "icons/enemy/enemy_108.png";
                        setMonsterC(monsterClass);
                        setMonsterUrl(urlImg);
                        setMonsterAttribute("Man");
                        break;
                    case 40:
                        monsterClass="rider";
                        urlImg = "icons/enemy/enemy_115.png";
                        setMonsterC(monsterClass);
                        setMonsterUrl(urlImg);
                        setMonsterAttribute("Earth");
                        break;
                    case 41:
                        monsterClass ="archer";
                        urlImg = "icons/enemy/enemy_118.png";
                        setMonsterC(monsterClass);
                        setMonsterUrl(urlImg);
                        setMonsterAttribute("Earth");
                        break;

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {
            }
        });

        tester.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(IDtaker.getText().toString()=="")
                {
                    servantClass.setText("You have to enter a number.");
                    servantPic.setImageResource(android.R.color.transparent);
                }
                else
                {
                    int ID = Integer.parseInt(IDtaker.getText().toString());
                    if (ID < 1)
                    {
                        servantClass.setText("Try Again, Servant IDs start at 1.");
                        servantPic.setImageResource(android.R.color.transparent);
                    }
                    else
                    {
                        servant_small newServant = new servant_small(ID);
                        if(newServant.isSpecial())
                        {
                            servantClass.setText("Try Again,Invalid Servant ID.");
                            servantPic.setImageResource(android.R.color.transparent);
                        }
                        else
                        {
                            if(getMonsterC()=="")
                            {
                                servantClass.setText("Select a monster to fight.");
                                servantPic.setImageResource(android.R.color.transparent);
                            }
                            else
                            {
                                servantClass.setText(newServant.getServantClass());
                                Portrait pic = new Portrait();
                                pic.setImage(servantPic);
                                pic.execute(newServant.getImageURL());
                                Portrait pic2 = new Portrait();
                                pic2.setImage(monsterPic);
                                pic2.execute(getMonsterUrl());
                                servantAttribute.setText("Attribute:\n" +newServant.getAttribute());
                                mclassPic.setImageResource(monsterCPic());
                                monsterAtt.setText("Attribute: \n" + getMonsterA());
                                servantAtk.setText("Attack: \n" + newServant.getATK());
                                buster.setVisibility(buster.VISIBLE);
                                arts.setVisibility(arts.VISIBLE);
                                quick.setVisibility(quick.VISIBLE);
                                undo.setVisibility(undo.VISIBLE);
                                buster.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        if(cards.size() < 3)
                                            cards.push(1);
                                        updateCardLog(cardLog);
                                    }
                                });
                                arts.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        if(cards.size() < 3)
                                            cards.push(2);
                                        updateCardLog(cardLog);
                                    }
                                });
                                quick.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        if(cards.size() < 3)
                                            cards.push(3);
                                        updateCardLog(cardLog);
                                    }
                                });
                                undo.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        if(!cards.isEmpty())
                                            cards.pop();
                                        updateCardLog(cardLog);
                                    }
                                });
                                //int drawableLocation = getResources().getIdentifier("drawable/" + newServant.classIcon(), null, null);
                                //Log.e("IMPORTANTE", newServant.getServantClass());
                                int drawableLocation = dmg_calculator.this.getResources().getIdentifier(newServant.classIcon(), "drawable", dmg_calculator.this.getPackageName());
                                //int drawableLocation = getResources().getIdentifier(newServant.classIcon(), "drawable", getPackageName());
                                classPic.setImageResource(drawableLocation);
                            }
                        }
                    }
                }
            }
        });
    }
    public void setMonsterC(String monsterclass)
    {
           monsterC = monsterclass;
    }

    public void setMonsterUrl(String monsterUrl)
    {
        this.monsterUrl = monsterUrl;
    }

    public void setMonsterAttribute(String monsterA) {
        this.monsterA = monsterA;
    }

    public int monsterCPic()
    {
        String location = "";
        if (getMonsterC().equalsIgnoreCase("Saber"))
            location = "saber3";
        else if (getMonsterC().equalsIgnoreCase( "Archer"))
            location = "archer3";
        else if (getMonsterC().equalsIgnoreCase("Lancer"))
            location = "lancer3";
        else if (getMonsterC().equalsIgnoreCase( "Caster"))
            location = "caster3";
        else if (getMonsterC().equalsIgnoreCase("Rider"))
            location = "rider3";
        else if (getMonsterC().equalsIgnoreCase("Assassin"))
            location = "assassin3";
        else if (getMonsterC().equalsIgnoreCase( "Berserker"))
            location = "berserker3";
        else if (getMonsterC().equalsIgnoreCase( "Ruler"))
            location = "ruler5";
        else if (getMonsterC().equalsIgnoreCase( "Avenger"))
            location = "avenger5";

        return dmg_calculator.this.getResources().getIdentifier(location, "drawable", dmg_calculator.this.getPackageName());
    }
    public String getMonsterC() {
        return monsterC;
    }

    public String getMonsterA() {
        return monsterA;
    }

    public String getMonsterUrl() {
        return "https://fate-go.cirnopedia.org/" + monsterUrl;
    }
    public void updateCardLog(TextView tv){
        String result = "";
        int[] holder = new int[3];
        int i = 0;
        int total = cards.size();
        if(!cards.isEmpty())
        {
            while(!cards.isEmpty())
            {
                holder[i] =(int) cards.pop();
                i++;
            }
            i=1;
            for(int k = total-1; k>-1; k--)
            {
                result += "Card "+ (i) +": ";
                if(holder[k]==1)
                    result+="Buster\n";
                if(holder[k]==2)
                    result+="Arts\n";
                if(holder[k]==3)
                    result+="Quick\n";
                //Log.e("MUYMUY","Here " +k);
                cards.push(holder[k]);
                i++;
            }
        }
        tv.setText(result);
    }
    public double[] cardDmg(int ATK, double classModifier, double classBonus, double attributemod, boolean crit)
    {
        int[] holder = {0,0,0};
        int i = 0;
        int total = cards.size();
        int servantAtk = ATK;
        double firstCardBonus;
        double triangleModifier = classModifier;
        double classAtkBonus = classBonus;
        double cardDamageValue1 = 0;
        double cardDamageValue2 = 0;
        double cardDamageValue3 = 0;
        double attributeModifier = attributemod;
        double extraCardModifier;
        double randomModifier = .9;
        int criticalModifier;
        double busterChainMod;
        double cardDmg1;
        double cardDmg2;
        double cardDmg3;
        double extraDmg;
        if(!cards.isEmpty()) {
            while (!cards.isEmpty()) {
                holder[i] = (int) cards.pop();
                i++;
            }
            i = 1;
            for (int k = total - 1; k > -1; k--) {
                //Log.e("MUYMUY","Here " +k);
                cards.push(holder[k]);
                i++;
            }
            if (holder[0] == 1)
                firstCardBonus = .5;
            else
                firstCardBonus = 0;

            if (holder[0] == 1)
                cardDamageValue1 = 1.5;
            else if (holder[1] == 1)
                cardDamageValue2 = 1.8;
            else if (holder[2] == 1)
                cardDamageValue3 = 2.1;
            if (holder[0] == 2)
                cardDamageValue1 = 1.0;
            else if (holder[1] == 2)
                cardDamageValue2 = 1.2;
            else if (holder[2] == 2)
                cardDamageValue3 = 1.4;
            if (holder[0] == 3)
                cardDamageValue1 = 0.8;
            else if (holder[1] == 3)
                cardDamageValue2 = 0.96;
            else if (holder[2] == 3)
                cardDamageValue3 = 1.12;
            if (crit)
                criticalModifier = 2;
            else
                criticalModifier = 1;
            if (holder[0] == 1 && holder[1] == 1 && holder[2] == 1)
                busterChainMod = .2;
            else
                busterChainMod = 0;

            randomModifier += rand.nextInt(3) * .1;

            cardDmg1 = servantAtk * (firstCardBonus + cardDamageValue1) * classAtkBonus * triangleModifier * attributeModifier * randomModifier * 0.23 * criticalModifier + (servantAtk * busterChainMod);
            cardDmg2 = servantAtk * (firstCardBonus + cardDamageValue2) * classAtkBonus * triangleModifier * attributeModifier * randomModifier * 0.23 * criticalModifier + (servantAtk * busterChainMod);
            cardDmg3 = servantAtk * (firstCardBonus + cardDamageValue3) * classAtkBonus * triangleModifier * attributeModifier * randomModifier * 0.23 * criticalModifier + (servantAtk * busterChainMod);
            if (total == 3) {
                if (holder[1] == holder[2] && holder[1] == holder[3])
                    extraCardModifier = 3.5;
                else
                    extraCardModifier = 2;
                extraDmg = servantAtk * (firstCardBonus + 1) * classAtkBonus * triangleModifier * attributeModifier * randomModifier * 0.23 * criticalModifier * extraCardModifier + (servantAtk * busterChainMod);
                double[] result = {cardDmg1, cardDmg2, cardDmg3, extraDmg};
                return result;
            } else {
                double[] result = {cardDmg1, cardDmg2, cardDmg3};
                return result;
            }//servantAtk  * (firstCardBonus + cardDamageValue) * classAtkBonus * triangleModifier * attributeModifier * randomModifier * 0.23 * (1) * criticalModifier * extraCardModifier * (1) +  (servantAtk * busterChainMod);

            //if(total == 3)
            //EXTRA CARD


            //dmgPlusAdd {X Damage Plus/Minus} // Note the lack of %. Divinity and Waver's 3rd skill, for example.
            //selfDmgCutAdd  = {X Damage Up/Cut} // Also a straight number. Waver's 2nd skill and Mashu's first, for example.
            //ardMod = {X% [Card] Power Up/Down}
            //atkMod = {X% Attack Up/Down}
            //defMod = {X% Defense Up/Down), Def Up (but not Def Down) is skipped if the NP ignores defense}]
            //specialDefMod = Given to some enemies like Quetz's in Babylon or Gawain in Camelot
            //powerMod = {X% Power Up/Down}
        }
        else
            return null;
    }
    public double getClassModifier(String c)
    {
        if (c.equalsIgnoreCase("Saber"))
            return 1.0;
        else if (c.equalsIgnoreCase( "Archer"))
            return .95;
        else if (c.equalsIgnoreCase("Lancer"))
            return 1.05;
        else if (c.equalsIgnoreCase( "Caster"))
            return 0.9;
        else if (c.equalsIgnoreCase("Rider"))
            return 1.0;
        else if (c.equalsIgnoreCase("Assassin"))
            return 0.9;
        else if (c.equalsIgnoreCase( "Berserker"))
            return 1.1;
        else if (c.equalsIgnoreCase( "Ruler"))
            return 1.1;
        else if (c.equalsIgnoreCase( "Avenger"))
            return 1.1;
        else
            return 1.0;
    }
}
