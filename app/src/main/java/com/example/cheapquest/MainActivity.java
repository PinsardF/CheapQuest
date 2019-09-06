package com.example.cheapquest;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sharedPreferences = getSharedPreferences("", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        int hero_attack = sharedPreferences.getInt("hero_attack",0);
        if(hero_attack==0){
            editor.putInt("hero_health",100);
            editor.putInt("hero_attack",5);
            editor.putInt("hero_lvl",1);
            editor.putInt("hero_xp",0);
            editor.apply();
        }
        /*editor.putInt("hero_lvl",1);
        editor.putInt("hero_xp",0);
        editor.apply();*/
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void demarrer(View view) {
        Intent mapIntent = new Intent(this,MapActivity.class);
        startActivity(mapIntent);
    }
}
