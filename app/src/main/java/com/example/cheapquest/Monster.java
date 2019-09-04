package com.example.cheapquest;

import android.graphics.drawable.Drawable;

public class Monster {
    final String name;
    final int attack;
    final int health;
    final int proba;
    final int xp_value;
    final int image;

    public Monster(String name, int attack, int health, int proba, int xp_value, int image){
        this.name = name;
        this.attack = attack;
        this.health = health;
        this.proba = proba;
        this.image = image;
        this.xp_value = xp_value;
    }

    public String getName(){
        return name;
    }

    public int getHealth(){
        return health;
    }

    public int getImage() {
        return image;
    }
}
