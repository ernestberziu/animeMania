package com.threel.animeshqip;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Episodes extends AppCompatActivity {


    DatabaseReference reference,reference1,reference2;
    RecyclerView recyclerView;
    ArrayList<episodesList> list;
    episodesAdapter episodesAdapter;
    androidx.appcompat.widget.Toolbar toolbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_episodes);
        toolbar = (Toolbar) findViewById(R.id.toolbarepisodes);
        toolbar.setTitle(Demo.name);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        recyclerView = (RecyclerView)findViewById(R.id.episodesrecycle);
        StaggeredGridLayoutManager gridLayoutManager =
                new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL);


        recyclerView.setLayoutManager(gridLayoutManager);
        list = new ArrayList<episodesList>();

        reference = FirebaseDatabase.getInstance().getReference().child("Series");
        reference1=reference.child(Demo.name);
        reference2=reference1.child("Episodes");

        reference2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){
                    episodesList s = dataSnapshot1.getValue(episodesList.class);
                    list.add(s);
                }

                episodesAdapter =new episodesAdapter(Episodes.this, list);
                recyclerView.setAdapter(episodesAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(Episodes.this, "Error",Toast.LENGTH_SHORT).show();
            }
        });

    }
}