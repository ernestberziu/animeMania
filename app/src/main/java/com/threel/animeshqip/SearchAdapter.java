package com.threel.animeshqip;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class SearchAdapter extends Adapter<SearchAdapter.MyViewHolder>{
    ArrayList<Searchlist> list;
    Context context;
    public SearchAdapter(ArrayList<Searchlist> list, Context c) {
        context =c;
        this.list=list;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.serachcard,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        Picasso.get().load(list.get(position).getImage()).into(holder.image);
        holder.name.setText(list.get(position).getName());
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Demo.name=list.get(position).getName();
                Intent episodes = new Intent(context, Episodes.class);
                context.startActivity(episodes);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView name;
            public MyViewHolder(@Nullable View itemView){
                super(itemView);
                image=itemView.findViewById(R.id.searchimage);
                name=itemView.findViewById(R.id.searchtitle);
            }
        }
    }

