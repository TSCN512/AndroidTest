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
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
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

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        monsters.setAdapter(adapter);
        monsters.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int position, long id)
            {
            
                switch (position) {
                    case 0:
                        String monsterClass ="saber";
                        break;
                    case 1:
                        // Whatever you want to happen when the second item gets selected
                        break;
                    case 2:
            
                        break;
                    case 3:
            
                        break;
                    case 4:
            
                        break;
                    case 5:
            
                        break;
                    case 6:
            
                        break;
                    case 7:
            
                        break;
                    case 8:
            
                        break;
                    case 9:
            
                        break;
                    case 10:
            
                        break;
                    case 11:
            
                        break;
                    case 12:
            
                        break;
                    case 13:
            
                        break;
                    case 14:
            
                        break;
                    case 15:
            
                        break;
                    case 16:
            
                        break;
                    case 17:
            
                        break;
                    case 18:
            
                        break;
                    case 19:
            
                        break;
                    case 20:
            
                        break;
                    case 21:
            
                        break;
                    case 22:
            
                        break;
                    case 23:
            
                        break;
                    case 24:
            
                        break;
                    case 25:
            
                        break;
                    case 26:
            
                        break;
                    case 27:
            
                        break;
                    case 28:
            
                        break;
                    case 29:
            
                        break;
                    case 30:
            
                        break;
                    case 31:
            
                        break;
                    case 32:
            
                        break;
                    case 33:
            
                        break;
                    case 34:
            
                        break;
                    case 35:
            
                        break;
                    case 36:
            
                        break;
                    case 37:
            
                        break;
                    case 38:
            
                        break;
                    case 39:
            
                        break;
                    case 40:
            
                        break;
                    case 41:
            
                        break;
            
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {
            }
        });
        IDtaker.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_CLASS_NUMBER); //block special characters
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
