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
                String monsterClass;
                switch (position)
                {
                    case 0:
                        monsterClass ="saber";
                        break;
                    case 1:
                        monsterClass ="archer";
                        break;
                    case 2:
                        monsterClass="lancer";
                        break;
                    case 3:
                        monsterClass ="saber";
                        break;
                    case 4:
                        monsterClass="lancer";
                        break;
                    case 5:
                        monsterClass ="saber";
                        break;
                    case 6:
                        monsterClass ="archer";
                        break;
                    case 7:
                        monsterClass="lancer";
                        break;
                    case 8:
                        monsterClass ="saber";
                        break;
                    case 9:
                        monsterClass ="archer";
                        break;
                    case 10:
                        monsterClass="berserker";
                        break;
                    case 11:
                        monsterClass="caster";
                        break;
                    case 12:
                        monsterClass ="saber";
                        break;
                    case 13:
                        monsterClass ="archer";
                        break;
                    case 14:
                        monsterClass="lancer";
                        break;
                    case 15:
                        monsterClass ="saber";
                        break;
                    case 16:
                        monsterClass ="archer";
                        break;
                    case 17:
                        monsterClass="lancer";
                        break;
                    case 18:
                        monsterClass="assassin";
                        break;
                    case 19:
                        monsterClass="rider";
                        break;
                    case 20:
                        monsterClass="rider";
                        break;
                    case 21:
                        monsterClass ="saber";
                        break;
                    case 22:
                        monsterClass="lancer";
                        break;
                    case 23:
                        monsterClass="assassin";
                        break;
                    case 24:
                        monsterClass="rider";
                        break;
                    case 25:
                        monsterClass="berserker";
                        break;
                    case 26:
                        monsterClass="caster";
                        break;
                    case 27:
                        monsterClass="lancer";
                        break;
                    case 28:
                        monsterClass="berserker";
                        break;
                    case 29:
                        monsterClass="assassin";
                        break;
                    case 30:
                        monsterClass="saber";
                        break;
                    case 31:
                        monsterClass ="archer";
                        break;
                    case 32:
                        monsterClass="caster";
                        break;
                    case 33:
                        monsterClass="assassin";
                        break;
                    case 34:
                        monsterClass ="archer";
                        break;
                    case 35:
                        monsterClass="lancer";
                        break;
                    case 36:
                        monsterClass ="saber";
                        break;
                    case 37:
                        monsterClass="assassin";
                        break;
                    case 38:
                        monsterClass="assassin";
                        break;
                    case 39:
                        monsterClass="assassin";
                        break;
                    case 40:
                        monsterClass="rider";
                        break;
                    case 41:
                        monsterClass ="archer";
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
                        Log.e("IMPORTANTE", newServant.getServantClass());
                        int drawableLocation = dmg_calculator.this.getResources().getIdentifier(newServant.classIcon(), "drawable", dmg_calculator.this.getPackageName());
                        //int drawableLocation = getResources().getIdentifier(newServant.classIcon(), "drawable", getPackageName());
                        classPic.setImageResource(drawableLocation);

                    }
                }
            }
        });
    }


}
