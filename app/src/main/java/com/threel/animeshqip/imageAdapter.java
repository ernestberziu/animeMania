package com.threel.animeshqip;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class imageAdapter extends RecyclerView.Adapter<imageAdapter.MyViewHolder> {
    Context context;
    ArrayList<Series> images;
    Welcome welcome;
    public imageAdapter(Context c , ArrayList<Series> i){
        context=c;
        images= i;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.cardview,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        Picasso.get().load(images.get(position).getImage()).into(holder.image);
       holder.image.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Demo.name=images.get(position).getName();
               Intent episodes = new Intent(context, Episodes.class);
               context.startActivity(episodes);
           }
       });



    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        ImageButton image;
        TextView name;
        public MyViewHolder(View itemview){
            super(itemview);
            image= (ImageButton) itemview.findViewById(R.id.image);

        }

    }
}
