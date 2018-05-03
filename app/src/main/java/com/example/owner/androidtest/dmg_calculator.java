package com.example.owner.androidtest;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.*;

public class dmg_calculator extends AppCompatActivity {

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
