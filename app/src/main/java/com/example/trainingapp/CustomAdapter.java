package com.example.trainingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class CustomAdapter extends BaseAdapter {

    public Context context;
    public String[] exercisesName;
    public int[] imagesGif;

    public CustomAdapter(Context context, String[] exercisesName, int[] imagesGif) {
        this.context = context;
        this.exercisesName = exercisesName;
        this.imagesGif = imagesGif;
    }

    @Override
    public int getCount() {
        return imagesGif.length;
    }

    @Override
    public Object getItem(int i) {
        return imagesGif[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        View view1 = inflater.inflate( R.layout.row_data, null );

        TextView name = view1.findViewById(R.id.exercises);
        ImageView image = view1.findViewById(R.id.images);

        name.setText(exercisesName[i]);
        image.setImageResource(imagesGif[i]);

        Glide.with(context)
                .load(imagesGif[i])
                .centerCrop()
                .into(image);

        return view1;
    }
}
