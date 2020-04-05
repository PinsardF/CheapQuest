package com.example.cheapquest;

public enum Level_enum {
    Level1(1,5,5,3),
    Level2(2,8,10,11),
    Level3(3,10,15,11),
    Level4(4,20,60,8),
    Level5(5,30,65,3),
    Level6(6,40,25,4),
    Level7(7,50,30,5),
    Level8(8,60,35,5),
    Level9(9,70,35,5),
    Level10(10,100,40,7),
    Level11(11,120,50,7),
    Level12(12,150,42,2),
    Level13(13,200,18,3),
    Level14(14,250,50,3),
    Level15(15,280,40,7),
    Level16(16,300,40,4),
    Level17(17,350,30,7),
    Level18(18,400,190,50),
    Level19(19,450,200,50),
    Level20(20,500,500,50),
    Level21(21,550,400,50),
    Level22(22,600,600,50),
    Level23(23,700,1000,60),
    Level24(24,800,500,60),
    Level25(25,900,800,80),
    Level26(26,1000,700,50),
    Level27(27,1100,1200,170),
    Level28(28,1300,100,20),
    Level29(29,1500,200,40),
    Level30(30,1,0,0);
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
