package com.example.cheapquest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void demarrer(View view) {
        Intent mapIntent = new Intent(this,MapActivity.class);
        startActivity(mapIntent);
    }
}
