package com.example.cheapquest;

public class Ennemy {
    String name;
    int attack;
    int health;
    int max_health;
    int xp_value;
    int image;

    public Ennemy(String name, int attack, int health, int proba, int xp_value, int image){
        this.name = name;
        this.attack = attack;
        this.health = health;
        this.max_health = health;
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

    public void setHealth(int health) {
        this.health = health;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setMax_health(int max_health){
        this.max_health = max_health;
    }

    public void setAttack(int attack){
        this.attack = attack;
    }

    public void setImage(int image){
        this.image = image;
    }

    public void setXp_value(int xp_value){
        this.xp_value = xp_value;
    }
}
