package com.threel.animeshqip;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class episodesAdapter extends RecyclerView.Adapter<episodesAdapter.MyViewHolder> {
    Context context;
    ArrayList<episodesList> episodes;
    public episodesAdapter(Context c , ArrayList<episodesList> i){
        context=c;
        episodes= i;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.episodescardview,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
            holder.title.setText(episodes.get(position).getName());
        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Demo.url=episodes.get(position).getLink();
                Demo.episodes=episodes.get(position).getName();
                Intent videoplayer = new Intent(context, VideoPlayer.class);
                context.startActivity(videoplayer);
            }
        });




    }

    @Override
    public int getItemCount() {
        return episodes.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        Button title;
        public MyViewHolder(View itemview){
            super(itemview);
            title= (Button) itemview.findViewById(R.id.title);

        }

    }
}
