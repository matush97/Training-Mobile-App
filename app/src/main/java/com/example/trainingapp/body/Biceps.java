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

public class Biceps extends AppCompatActivity {
    String[] exercisesName = {"Bicepsový zdvih s jednoručkou", "Kladivový zdvih s jednoručkami", "Bicepsový zdvih v sede na lavičke"};
    int[] imagesGif = {
            R.drawable.bicepsovy_zdvih_s_jednoruckou,
            R.drawable.kladivovy_zdvih_s_jednoruckami,
            R.drawable.bicepsovy_zdvih_v_sede_na_lavicke
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biceps);

        GridView gridView = findViewById(R.id.gridBiceps);
        gridView.setAdapter(new CustomAdapter(this, exercisesName, imagesGif));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), GridItemActivity.class);
                intent.putExtra("name", exercisesName[position]);
                intent.putExtra("image", imagesGif[position]);

                switch (position){
                    case 0:
                        intent.putExtra("information", Constants.BicepsInfo.bicepsovyZdvihJednoruckamiInfo);
                        break;
                    case 1:
                        intent.putExtra("information", Constants.BicepsInfo.kladivovyZdvihJednoruckamiInfo);
                        break;
                    case 2:
                        intent.putExtra("information", Constants.BicepsInfo.bicepsovyZdvihSedeInfo );
                        break;
                }
                startActivity(intent);
            }
        });
    }
}