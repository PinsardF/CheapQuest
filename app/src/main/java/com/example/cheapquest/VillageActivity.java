package com.example.cheapquest;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class VillageActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_village);
        sharedPreferences = getSharedPreferences("", Context.MODE_PRIVATE);
        TextView lvl = findViewById(R.id.village_lvl);
        int hero_lvl = sharedPreferences.getInt("hero_lvl",0);
        lvl.setText("Niveau "+hero_lvl);
        TextView xp = findViewById(R.id.village_xp);
        int hero_xp = sharedPreferences.getInt("hero_xp",0);
        Level_enum[] values_lvl = Level_enum.values();
        Level_enum lvl_actuel = Level_enum.Level1;
        for (Level_enum value_lvl : values_lvl){
            if(value_lvl.lvl == hero_lvl){
                lvl_actuel = value_lvl;
            }
        }
        int xp_needed = lvl_actuel.xp_needed;
        xp.setText("XP :"+hero_xp+"/"+xp_needed);
        int hero_health = sharedPreferences.getInt("hero_health",0);
        int hero_attack = sharedPreferences.getInt("hero_attack",0);
        TextView stats = findViewById(R.id.village_stats);
        stats.setText("Vie max : "+hero_health+"\nAttaque : "+hero_attack);
        ImageView image = findViewById(R.id.village_image);
        image.setImageDrawable(getDrawable(R.drawable.character));
    }

    public void village_quit(View view){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {public void run() { finish(); }}, 1000);
    }
}
