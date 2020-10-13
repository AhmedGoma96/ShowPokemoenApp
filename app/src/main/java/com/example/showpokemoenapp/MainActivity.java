package com.example.showpokemoenapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;


import com.example.showpokemoenapp.Model.ResultsItem;

import java.util.ArrayList;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {
 private PokemoenViewModel viewModel;
 private RecyclerView recyclerView;
 private PokemoenAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.pokemoen_recycler_view);
        adapter=new PokemoenAdapter(this);
        recyclerView.setAdapter(adapter);
        viewModel=new ViewModelProvider(this).get(PokemoenViewModel.class);
        viewModel.getPokemons();
        viewModel.mutableLiveData.observe(this, new Observer<ArrayList<ResultsItem>>() {
            @Override
            public void onChanged(ArrayList<ResultsItem> resultsItems) {
                adapter.setList(resultsItems);
            }
        });


    }
}