package com.example.cheapquest;

public enum Level_enum {
    Level1(1,5,10,3),
    Level2(2,15,10,2),
    Level3(3,36,8,3),
    Level4(4,50,8,4);
    int lvl;
    int xp_needed;
    int health_plus;
    int attack_plus;
    Level_enum(int lvl, int xp_needed, int health_plus, int attack_plus){
        this.lvl = lvl;
        this.xp_needed = xp_needed;
        this.health_plus = health_plus;
        this.attack_plus = attack_plus;
    }
}
