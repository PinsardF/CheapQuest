package com.example.cheapquest;

import java.util.ArrayList;
import java.util.Arrays;

public enum Zones_enum {
    chemin("chemin",new ArrayList<String>(Arrays.asList("Bandit"))),
    bois("bois",new ArrayList<String>(Arrays.asList("Arbre"))),
    rocher("rocher",new ArrayList<String>(Arrays.asList("Golem"))),
    entree_foret("foret_entree",new ArrayList<String>(Arrays.asList("Fée"))),
    foret_dense("foret_dense",new ArrayList<String>(Arrays.asList("Mouche"))),
    chateau("chateau",new ArrayList<String>(Arrays.asList("Chevalier"))),
    mare("mare",new ArrayList<String>(Arrays.asList("Canard")));

    String nom;
    ArrayList<String> monsters;

    Zones_enum(String nom, ArrayList<String> monsters){
        this.nom = nom;
        this.monsters = monsters;
    }
}
