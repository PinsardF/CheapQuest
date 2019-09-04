package com.example.cheapquest;

import android.graphics.drawable.Drawable;

public class Monster {
    final String name;
    final int attack;
    int health;
    final int max_health;
    final int proba;
    final int xp_value;
    int image;

    public Monster(String name, int attack, int health, int proba, int xp_value, int image){
        this.name = name;
        this.attack = attack;
        this.health = health;
        this.max_health = health;
        this.proba = proba;
        this.image = image;
        this.xp_value = xp_value;
    }
}
