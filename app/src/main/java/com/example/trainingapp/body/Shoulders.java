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

public class Shoulders extends AppCompatActivity {
    String[] exercisesName = {"Tlaky s jednoruckami v sede", "Rozpazovanie", "Zapazovanie"};
    int[] imagesGif = {
            R.drawable.tlaky_nad_hlavou_s_jednoruckami_v_sede,
            R.drawable.rozpazovanie,
            R.drawable.zapazovanie,

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoulders);

        GridView gridView = findViewById(R.id.gridShoulders);
        gridView.setAdapter(new CustomAdapter(this, exercisesName, imagesGif));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), GridItemActivity.class);
                intent.putExtra("name", exercisesName[position]);
                intent.putExtra("image", imagesGif[position]);

                switch (position){
                    case 0:
                        intent.putExtra("information", Constants.ShouldersInfo.tlakySJednoruckamiInfo);
                        break;
                    case 1:
                        intent.putExtra("information", Constants.ShouldersInfo.rozpazovanieInfo);
                        break;
                    case 2:
                        intent.putExtra("information", Constants.ShouldersInfo.zapazovanieInfo );
                        break;

                }
                startActivity(intent);
            }
        });
    }
}