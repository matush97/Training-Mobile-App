package com.example.trainingapp.body;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.trainingapp.CustomAdapter;
import com.example.trainingapp.GridItemActivity;
import com.example.trainingapp.R;
import com.example.trainingapp.body.constats.Constants;

public class Legs extends AppCompatActivity {
    String[] exercisesName = {"Drep", "Vypady s jednoruckami", "Leg press", "Predkopavanie", "Zakopavanie"};
    int[] imagesGif = {
            R.drawable.drep,
            R.drawable.vypady_s_jednoruckami,
            R.drawable.leg_press,
            R.drawable.predkopavanie,
            R.drawable.zakopavanie
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_legs);

        GridView gridView = findViewById(R.id.gridLegs);
        gridView.setAdapter(new CustomAdapter(this, exercisesName, imagesGif));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), GridItemActivity.class);
                intent.putExtra("name", exercisesName[position]);
                intent.putExtra("image", imagesGif[position]);

                switch (position){
                    case 0:
                        intent.putExtra("information", Constants.LegsInfo.drepInfo);
                        break;
                    case 1:
                        intent.putExtra("information", Constants.LegsInfo.vypadySJednoruckamiInfo);
                        break;
                    case 2:
                        intent.putExtra("information", Constants.LegsInfo.legPressInfo );
                        break;
                    case 3:
                        intent.putExtra("information", Constants.LegsInfo.predkopavanieInfo);
                        break;
                    case 4:
                        intent.putExtra("information", Constants.LegsInfo.zakopavanieInfo);
                        break;
                }
                startActivity(intent);
            }
        });
    }
}
