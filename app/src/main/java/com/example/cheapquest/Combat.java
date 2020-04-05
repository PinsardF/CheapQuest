package com.example.cheapquest;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.logging.Level;

public class Combat extends AppCompatActivity {

    Ennemy ennemy;
    Character hero;
    Animation testanim;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sharedPreferences = getSharedPreferences("", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        int lvl = sharedPreferences.getInt("hero_lvl",0);
        int attack = sharedPreferences.getInt("hero_attack",0);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combat);
        load_characters();
        load_infos();
        TextView textBox = findViewById(R.id.textbox);
        textBox.setText("\""+ennemy.getName()+"\" apparaît !");
    }

    private void load_infos() {
        TextView ennemy_name = findViewById(R.id.ennemy_name);
        TextView ennemy_health = findViewById(R.id.ennemy_health);
        TextView hero_name = findViewById(R.id.hero_name);
        TextView hero_health = findViewById(R.id.hero_health);
        ennemy_name.setText(ennemy.getName());
        String ennemy_h = Integer.toString(ennemy.getHealth());
        ennemy_health.setText(ennemy_h+"/"+ennemy_h+" PV");
        hero_name.setText(hero.getName());
        String hero_h = Integer.toString(hero.getHealth());
        hero_health.setText(hero_h+"/"+hero_h+" PV");
        ImageView hero_image = findViewById(R.id.hero_image);
        hero_image.setImageDrawable(getDrawable(hero.getImage()));
        ImageView ennemy_image = findViewById(R.id.ennemy_image);
        ennemy_image.setImageDrawable(getDrawable(ennemy.getImage()));
        testanim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slice);
        ennemy_image.startAnimation(testanim);
    }

    private void load_characters() {
        String nom_zone = getIntent().getStringExtra("zone");
        Zones_enum[] values = Zones_enum.values();
        Zones_enum zone = Zones_enum.chemin;
        for (Zones_enum value : values){
            if(value.nom.equals(nom_zone)){
                zone = value;
            }
        }
        String ennemy_name = zone.monsters.get(0);

        Monsters_enum[] values_monsters = Monsters_enum.values();
        Monsters_enum monster = Monsters_enum.Bandit;
        for(Monsters_enum value_monster : values_monsters){
            if(value_monster.name.equals(ennemy_name)){
                monster = value_monster;
            }
        }
        ennemy = new Ennemy("Bandit",3,10,1,1,R.drawable.tiny_hero);
        ennemy.setName(monster.name);
        ennemy.setAttack(monster.attack);
        ennemy.setHealth(monster.health);
        ennemy.setMax_health(monster.health);
        ennemy.setImage(monster.image);
        ennemy.setXp_value(monster.xp_value);

        int hero_attack = sharedPreferences.getInt("hero_attack",0);
        int hero_health = sharedPreferences.getInt("hero_health",0);
        int hero_lvl = sharedPreferences.getInt("hero_lvl",0);
        int hero_xp = sharedPreferences.getInt("hero_xp",0);
        hero = new Character("Vous",hero_attack,hero_health,hero_lvl,hero_xp,R.drawable.character);
        //attack : 5    health : 100
    }

    public void attack(View view) {
        TextView textBox = findViewById(R.id.textbox);

        int new_ennemy_health = ennemy.getHealth()-hero.getAttack();
        if(new_ennemy_health <= 0){
            new_ennemy_health = 0;
        }
        ennemy.setHealth(new_ennemy_health);
        textBox.setText("Vous infligez "+hero.getAttack()+" dégats à \""+ennemy.getName()+"\".");
        TextView ennemy_health = findViewById(R.id.ennemy_health);
        if(ennemy.health > 0) {
            ennemy_health.setText(ennemy.getHealth() + "/" + ennemy.max_health + " PV");
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {public void run() { ennemy_attack(); }}, 1000);
        }else{
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {public void run() { ennemy_death(); }}, 1000);
        }
    }

    private void ennemy_death() {
        TextView textBox = findViewById(R.id.textbox);

        TextView ennemy_health = findViewById(R.id.ennemy_health);
        ennemy_health.setText("Mort");
        textBox.setText("Vous avez vaincu \""+ennemy.getName()+"\" !");
        Button atk_button = findViewById(R.id.button_attack);
        atk_button.setEnabled(false);
        Button magik_button = findViewById(R.id.button_magie);
        magik_button.setEnabled(false);
        Button run_button = findViewById(R.id.button_fuir);
        run_button.setEnabled(false);

        int hero_xp = sharedPreferences.getInt("hero_xp",0);
        System.out.println(hero_xp);
        final int hero_lvl = sharedPreferences.getInt("hero_lvl",0);
        Level_enum[] values_lvl = Level_enum.values();
        Level_enum lvl = Level_enum.Level1;
        for (Level_enum value_lvl : values_lvl){
            if(value_lvl.lvl == hero_lvl){
                lvl = value_lvl;
            }
        }
        hero_xp += ennemy.getXp_value();
        if(hero.lvl < 5) {
            if (hero_xp >= lvl.xp_needed) {
                hero_xp -= lvl.xp_needed;
                editor.putInt("hero_lvl", hero_lvl + 1);
            }
            editor.putInt("hero_xp", hero_xp);
            editor.apply();
        }

        Handler handler = new Handler();
        final int finalHero_xp = sharedPreferences.getInt("hero_xp",0);
        final int finalHero_lvl = sharedPreferences.getInt("hero_lvl",0);
        handler.postDelayed(new Runnable() {public void run() {
            TextView textbox = findViewById(R.id.textbox);
            textbox.setText("Lvl "+finalHero_lvl+", xp :"+ finalHero_xp);
        }}, 1000);

        handler.postDelayed(new Runnable() {public void run() { finish(); }}, 1000);
    }

    private void ennemy_attack() {
        TextView textBox = findViewById(R.id.textbox);

        int new_hero_health = hero.getHealth()-ennemy.attack;
        hero.setHealth(new_hero_health);
        TextView hero_health = findViewById(R.id.hero_health);
        hero_health.setText(hero.getHealth()+"/"+hero.getMax_health()+" PV");
        textBox.setText("\""+ennemy.getName()+"\" vous a infligé "+ennemy.attack+" dégats.");
    }

    public void fuir(View view) {
        TextView textbox = findViewById(R.id.textbox);
        textbox.setText("Vous prenez la fuite.");
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {public void run() { finish(); }}, 1000);
    }
}