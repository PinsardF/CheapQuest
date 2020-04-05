package com.example.cheapquest;

import android.graphics.drawable.Drawable;


public enum Monsters_enum {
    Bandit("Bandit",3,10,1,1,R.drawable.bandit),
    Arbre("Arbre",6,40,1,3,R.drawable.arbre),
    Golem("Golem",15,110,1,9,R.drawable.golem),
    Fee("Fée",60,150,1,16,R.drawable.fee),
    Mouche("Mouche",70,260,1,30,R.drawable.mouche),
    Chevalier("Chevalier",100,600,1,55,R.drawable.chevalier),
    Canard("Canard",555,9000,1,200,R.drawable.canard);
    String name;
    int attack;
    int health;
    int proba;
    int xp_value;
    int image;

    Monsters_enum(String name, int attack, int health, int proba, int xp_value, int image){
        this.name = name;
        this.attack = attack;
        this.health = health;
        this.proba = proba;
        this.image = image;
        this.xp_value = xp_value;
    }
}
