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

import static com.example.trainingapp.body.constats.Constants.*;

public class Chest extends AppCompatActivity {
    String[] exercisesName = {"Bench press", "Dipy", "Kliky", "Rozpažovanie s jednoručkami", "Tlaky s jednoručkami na šikmej lavičke"};
    int[] imagesGif = {
            R.drawable.bench_press,
            R.drawable.dipy,
            R.drawable.kliky,
            R.drawable.rozpazovanie_s_jednoruckami,
            R.drawable.tlaky_s_jednoruckami_na_sikmej_lavicke
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest);

        GridView gridView = findViewById(R.id.gridChest);
        gridView.setAdapter(new CustomAdapter(this, exercisesName, imagesGif));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), GridItemActivity.class);
                intent.putExtra("name", exercisesName[position]);
                intent.putExtra("image", imagesGif[position]);

                switch (position){
                    case 0:
                        intent.putExtra("information", ChestInfo.benchPressInfo);
                        break;
                    case 1:
                        intent.putExtra("information", ChestInfo.dipyInfo);
                        break;
                    case 2:
                        intent.putExtra("information", ChestInfo.klikyInfo );
                        break;
                    case 3:
                        intent.putExtra("information", ChestInfo.rozpacovanieInfo);
                        break;
                    case 4:
                        intent.putExtra("information", ChestInfo.tlakyInfo);
                        break;
                }
                startActivity(intent);
            }
        });
    }
}