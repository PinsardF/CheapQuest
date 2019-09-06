package com.example.cheapquest;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

public class Character {
    String name;
    int attack;
    int health;
    int max_health;
    int lvl;
    int xp_gauge;
    int image;

    public Character(String name, int attack, int health, int lvl, int xp_gauge, int image){
        this.name = name;
        this.attack = attack;
        this.health = health;
        this.max_health = health;
        this.lvl = lvl;
        this.xp_gauge = xp_gauge;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public int getAttack(){
        return attack;
    }

    public int getHealth() {
        return health;
    }

    public int getMax_health(){
        return max_health;
    }

    public int getImage(){
        return image;
    }

    public void setName(String new_name){
        this.name = new_name;
    }

    public void setHealth(int new_health){
        this.health = new_health;
    }

    public void setAttack(int new_attack){
        this.attack = new_attack;
    }

    public void setMax_health(int new_max_health){
        this.max_health = new_max_health;
    }
}
