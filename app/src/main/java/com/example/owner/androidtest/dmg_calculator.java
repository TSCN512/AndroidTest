package com.example.owner.androidtest;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.*;

public class dmg_calculator extends AppCompatActivity{

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
        final ImageView classPic = (ImageView) findViewById(R.id.class_icon);
        final EditText IDtaker = (EditText) findViewById(R.id.idTaker);
        final Spinner monsters = (Spinner)findViewById(R.id.monsterSpinner);



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
                        break;
                    case 1:
                        monsterClass ="archer";
                        urlImg = "icons/enemy/enemy_009-03.png";
                        break;
                    case 2:
                        monsterClass="lancer";
                        urlImg = "icons/enemy/enemy_009-02.png";
                        break;
                    case 3:
                        monsterClass ="saber";
                        urlImg = "icons/enemy/enemy_011-01.png";
                        break;
                    case 4:
                        monsterClass="lancer";
                        urlImg = "icons/enemy/enemy_011-02.png";
                        break;
                    case 5:
                        monsterClass ="saber";
                        urlImg = "icons/enemy/enemy_019-01.png";
                        break;
                    case 6:
                        monsterClass ="archer";
                        urlImg = "icons/enemy/enemy_019-03.png";
                        break;
                    case 7:
                        monsterClass="lancer";
                        urlImg = "icons/enemy/enemy_019-02.png";
                        break;
                    case 8:
                        monsterClass ="saber";
                        urlImg = "icons/enemy/enemy_037-01.png";
                        break;
                    case 9:
                        monsterClass ="archer";
                        urlImg = "icons/enemy/enemy_037-03.png";
                        break;
                    case 10:
                        monsterClass="berserker";
                        urlImg = "icons/enemy/enemy_037-07.png";
                        break;
                    case 11:
                        monsterClass="caster";
                        urlImg = "icons/enemy/enemy_089-05.png";
                        break;
                    case 12:
                        monsterClass ="saber";
                        urlImg = "icons/enemy/enemy_089-01.png";
                        break;
                    case 13:
                        monsterClass ="archer";
                        urlImg = "icons/enemy/enemy_089-03.png";
                        break;
                    case 14:
                        monsterClass="lancer";
                        urlImg = "icons/enemy/enemy_089-02.png";
                        break;
                    case 15:
                        monsterClass ="saber";
                        urlImg = "icons/enemy/enemy_044.png";
                        break;
                    case 16:
                        monsterClass ="archer";
                        urlImg = "icons/enemy/enemy_044.png";
                        break;
                    case 17:
                        monsterClass="lancer";
                        urlImg = "icons/enemy/enemy_044.png";
                        break;
                    case 18:
                        monsterClass="assassin";
                        urlImg = "icons/enemy/enemy_022.png";
                        break;
                    case 19:
                        monsterClass="rider";
                        urlImg = "icons/enemy/enemy_013.png";
                        break;
                    case 20:
                        monsterClass="rider";
                        urlImg = "icons/enemy/enemy_039.png";
                        break;
                    case 21:
                        monsterClass ="saber";
                        urlImg = "icons/enemy/enemy_036.png";
                        break;
                    case 22:
                        monsterClass="lancer";
                        urlImg = "icons/enemy/enemy_036.png";
                        break;
                    case 23:
                        monsterClass="assassin";
                        urlImg = "icons/enemy/enemy_036.png";
                        break;
                    case 24:
                        monsterClass="rider";
                        urlImg = "icons/enemy/enemy_062.png";
                        break;
                    case 25:
                        monsterClass="berserker";
                        urlImg = "icons/enemy/enemy_030.png";
                        break;
                    case 26:
                        monsterClass="caster";
                        urlImg = "icons/enemy/enemy_026.png";
                        break;
                    case 27:
                        monsterClass="lancer";
                        urlImg = "icons/enemy/enemy_041.png";
                        break;
                    case 28:
                        monsterClass="berserker";
                        urlImg = "icons/enemy/enemy_027.png";
                        break;
                    case 29:
                        monsterClass="assassin";
                        urlImg = "icons/enemy/enemy_079.png";
                        break;
                    case 30:
                        monsterClass="saber";
                        urlImg = "icons/enemy/enemy_082.png";
                        break;
                    case 31:
                        monsterClass ="archer";
                        urlImg = "icons/enemy/enemy_086.png";
                        break;
                    case 32:
                        monsterClass="caster";
                        urlImg = "icons/enemy/enemy_073.png";
                        break;
                    case 33:
                        monsterClass="assassin";
                        urlImg = "icons/enemy/enemy_090.png";
                        break;
                    case 34:
                        monsterClass ="archer";
                        urlImg = "icons/enemy/enemy_091.png";
                        break;
                    case 35:
                        monsterClass="lancer";
                        urlImg = "icons/enemy/enemy_092.png";
                        break;
                    case 36:
                        monsterClass ="saber";
                        urlImg = "icons/enemy/enemy_093.png";
                        break;
                    case 37:
                        monsterClass="assassin";
                        urlImg = "icons/enemy/enemy_106.png";
                        break;
                    case 38:
                        monsterClass="assassin";
                        urlImg = "icons/enemy/enemy_107.png";
                        break;
                    case 39:
                        monsterClass="assassin";
                        urlImg = "icons/enemy/enemy_108.png";
                        break;
                    case 40:
                        monsterClass="rider";
                        urlImg = "icons/enemy/enemy_115.png";
                        break;
                    case 41:
                        monsterClass ="archer";
                        urlImg = "icons/enemy/enemy_118.png";
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
            public void onClick(View v) {
                if(IDtaker.getText().toString()=="")
                {
                    servantClass.setText("You have to enter a number.");
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
                        servantClass.setText(newServant.getServantClass());
                        Portrait pic = new Portrait();
                        pic.setImage(servantPic);
                        pic.execute(newServant.getImageURL());
                        //int drawableLocation = getResources().getIdentifier("drawable/" + newServant.classIcon(), null, null);
                        //Log.e("IMPORTANTE", newServant.getServantClass());
                        int drawableLocation = dmg_calculator.this.getResources().getIdentifier(newServant.classIcon(), "drawable", dmg_calculator.this.getPackageName());
                        //int drawableLocation = getResources().getIdentifier(newServant.classIcon(), "drawable", getPackageName());
                        classPic.setImageResource(drawableLocation);

                    }
                }
            }
        });
    }
    //public void


}
