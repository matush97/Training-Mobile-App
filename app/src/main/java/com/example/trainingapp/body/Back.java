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

public class Back extends AppCompatActivity {
    String[] exercisesName = {"Zhyby nadhmatom", "Príťahy v predklone s veľkou činkou", "Face pull", "Pokrčenia pliec s jednoručkami", "Hyperextenzie"};
    int[] imagesGif = {
            R.drawable.zhyby_nadhmatom,
            R.drawable.pritahy_v_predklone_s_velkou_cinkou,
            R.drawable.face_pull,
            R.drawable.pokrcenia_pliec_s_jednoruckami,
            R.drawable.hyperextenzie
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back);

        GridView gridView = findViewById(R.id.gridBack);
        gridView.setAdapter(new CustomAdapter(this, exercisesName, imagesGif));


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), GridItemActivity.class);
                intent.putExtra("name", exercisesName[position]);
                intent.putExtra("image", imagesGif[position]);

                switch (position){
                    case 0:
                        intent.putExtra("information", Constants.BackInfo.zhybyNadhmatomInfo);
                        break;
                    case 1:
                        intent.putExtra("information", Constants.BackInfo.pritahyVelkaCinkaInfo);
                        break;
                    case 2:
                        intent.putExtra("information", Constants.BackInfo.facePullInfo );
                        break;
                    case 3:
                        intent.putExtra("information", Constants.BackInfo.pokrceniaPliecJednoruckamiInfo);
                        break;
                    case 4:
                        intent.putExtra("information", Constants.BackInfo.hyperextenzieInfo);
                        break;
                }

                startActivity(intent);
            }
        });
    }
}