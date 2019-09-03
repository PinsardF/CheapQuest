package com.example.cheapquest;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Combat extends AppCompatActivity {

    Character ennemy;
    Character hero;
    Animation testanim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combat);
        load_characters();
        load_infos();
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
        hero_image.setImageDrawable(hero.getImage());
        ImageView ennemy_image = findViewById(R.id.ennemy_image);
        ennemy_image.setImageDrawable(ennemy.getImage());
        testanim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slice);
        ennemy_image.startAnimation(testanim);
    }

    private void load_characters() {
        ennemy = new Character("Monstre", 3, 10,getDrawable(R.drawable.hero));
        hero = new Character("Vous",5,50,getDrawable(R.drawable.monster));
    }

    public void attack(View view) {
        int new_ennemy_health = ennemy.getHealth()-hero.getAttack();
        if(new_ennemy_health <= 0){
            new_ennemy_health = 0;
        }
        ennemy.setHealth(new_ennemy_health);
        TextView ennemy_health = findViewById(R.id.ennemy_health);
        if(ennemy.health > 0) {
            ennemy_health.setText(ennemy.health + "/" + ennemy.max_health + " PV");
            ennemy_attack();
        }else{
            ennemy_death();
        }
    }

    private void ennemy_death() {
        TextView ennemy_health = findViewById(R.id.ennemy_health);
        ennemy_health.setText("Mort");
    }

    private void ennemy_attack() {
        int new_hero_health = hero.getHealth()-ennemy.getAttack();
        hero.setHealth(new_hero_health);
        TextView hero_health = findViewById(R.id.hero_health);
        hero_health.setText(hero.health+"/"+hero.max_health+" PV");
    }
}