package com.example.cheapquest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MapActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
    }

    public void go_to_zone(View map){
        /*switch(map.getTag().toString()){
            case ""
        }*/
        Intent combatIntent = new Intent(this,Combat.class);
        String zone = map.getTag().toString();
        combatIntent.putExtra("zone",zone);
        startActivity(combatIntent);
    }

    public void go_to_village(){
        finish();
        System.exit(0);
    }
}
