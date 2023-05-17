package com.example.trainingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.trainingapp.body.Back;
import com.example.trainingapp.body.Biceps;
import com.example.trainingapp.body.Chest;
import com.example.trainingapp.body.Legs;
import com.example.trainingapp.body.Shoulders;
import com.example.trainingapp.body.Triceps;

public class MainActivity extends AppCompatActivity {

    Button chestButton;
    Button backButton;
    Button legsButton;
    Button shouldersButton;
    Button tricepsButton;
    Button bicepsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chestButton = (Button) findViewById(R.id.chestButton);
        chestButton.setOnClickListener((b) ->{
            Intent intent = new Intent(getBaseContext(), Chest.class);
            startActivity(intent);
        });

        backButton = (Button) findViewById(R.id.backButton);
        backButton.setOnClickListener((b) ->{
            Intent intent = new Intent(getBaseContext(), Back.class);
            startActivity(intent);
        });

        legsButton = (Button) findViewById(R.id.legsButton);
        legsButton.setOnClickListener((b) ->{
            Intent intent = new Intent(getBaseContext(), Legs.class);
            startActivity(intent);
        });

        shouldersButton = (Button) findViewById(R.id.shouldersButton);
        shouldersButton.setOnClickListener((b) ->{
            Intent intent = new Intent(getBaseContext(), Shoulders.class);
            startActivity(intent);
        });

        tricepsButton = (Button) findViewById(R.id.tricepsButton);
        tricepsButton.setOnClickListener((b) ->{
            Intent intent = new Intent(getBaseContext(), Triceps.class);
            startActivity(intent);
        });

        bicepsButton = (Button) findViewById(R.id.bicepsButton);
        bicepsButton.setOnClickListener((b) ->{
            Intent intent = new Intent(getBaseContext(), Biceps.class);
            startActivity(intent);
        });

    }
}