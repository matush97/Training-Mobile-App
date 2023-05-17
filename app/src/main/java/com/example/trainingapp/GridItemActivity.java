package com.example.trainingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class GridItemActivity extends AppCompatActivity {

    TextView name;
    ImageView image;
    TextView information;

    EditText barbellWeightText;
    EditText numberRepeatingText;
    TextView textOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_item);

        name = findViewById(R.id.gridData);
        image = findViewById(R.id.imageView);
        information = findViewById(R.id.textInformation);

        barbellWeightText = (EditText) findViewById(R.id.barbellWeight);
        numberRepeatingText = (EditText) findViewById(R.id.numberRepeating);

        Intent intent = getIntent();
        name.setText(intent.getStringExtra("name"));
        Glide.with(this)
                .load(intent.getIntExtra("image", 0))
                .into(image);
        information.setText(intent.getStringExtra("information"));

        Button button = findViewById(R.id.calculateButton);
        button.setOnClickListener((v)->{
            String barbellWeight = barbellWeightText.getText().toString();
            String numberRepeating = numberRepeatingText.getText().toString();

            Calculate.barbellWeight = Double.parseDouble(barbellWeight);
            Calculate.numberRepeating = Double.parseDouble(numberRepeating);
            String result = Calculate.maxWeight();

            textOutput = (TextView) findViewById(R.id.textOutput);
            textOutput.setText((result));
        });

    }
}