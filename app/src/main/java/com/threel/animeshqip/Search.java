package com.threel.animeshqip;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;



import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Search extends AppCompatActivity {
    DatabaseReference ref;
    ArrayList<Searchlist> list;
    RecyclerView recyclerView;
    EditText searchView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ref= FirebaseDatabase.getInstance().getReference().child("Series").child(Demo.name);
        recyclerView=(RecyclerView) findViewById(R.id.recycleview);
        searchView=(EditText) findViewById(R.id.searchzone);


    }
    @Override
    protected void onStart(){
        super.onStart();
        if(ref!=null){
            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if(snapshot.exists()){
                        list=new ArrayList<>();
                        for(DataSnapshot ds: snapshot.getChildren()){
                            list.add(ds.getValue(Searchlist.class));
                        }
                        SearchAdapter searchAdapter=new SearchAdapter(list,Search.this);
                        recyclerView.setAdapter(searchAdapter);

                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }
        if(searchView!=null){
            searchView.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        search(charSequence.toString());
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
        }
    }
    private void search(String str){
        ArrayList<Searchlist> mylist =new ArrayList<>();
        for (Searchlist object:list){
            if(object.getName().toLowerCase().contains(str.toLowerCase())){
                mylist.add(object);
            }
        }
        SearchAdapter searchAdapter =new SearchAdapter(mylist,Search.this);
        recyclerView.setAdapter(searchAdapter);
    }
}