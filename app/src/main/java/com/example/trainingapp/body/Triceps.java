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

public class Triceps extends AppCompatActivity {
    String[] exercisesName = {"Skull crusher s veľkou činkou", "Sťahovanie hornej kladky", "Kickback s jednoručkou v predklone"};
    int[] imagesGif = {
            R.drawable.skull_crusher_s_velkou_cinkou,
            R.drawable.stahovanie_hornej_kladky,
            R.drawable.kickback_s_jednoruckou_v_predklone
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triceps);

        GridView gridView = findViewById(R.id.gridTriceps);
        gridView.setAdapter(new CustomAdapter(this, exercisesName, imagesGif));
        
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), GridItemActivity.class);
                intent.putExtra("name", exercisesName[position]);
                intent.putExtra("image", imagesGif[position]);

                switch (position){
                    case 0:
                        intent.putExtra("information", Constants.TricepsInfo.skullCrusherInfo);
                        break;
                    case 1:
                        intent.putExtra("information", Constants.TricepsInfo.stahovanieHornejKladkyInfo);
                        break;
                    case 2:
                        intent.putExtra("information", Constants.TricepsInfo.kickbackInfo );
                        break;
                }
                startActivity(intent);
            }
        });

    }
}