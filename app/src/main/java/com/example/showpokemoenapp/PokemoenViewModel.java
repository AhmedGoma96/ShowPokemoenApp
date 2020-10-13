package com.example.showpokemoenapp;


import android.util.Log;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.example.showpokemoenapp.Model.PokemonResponse;
import com.example.showpokemoenapp.Model.ResultsItem;

import java.util.ArrayList;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class PokemoenViewModel extends ViewModel {
    private Repositry repositry;
    MutableLiveData<ArrayList<ResultsItem>> mutableLiveData = new MutableLiveData<>();

    @ViewModelInject
    public PokemoenViewModel(Repositry repositry) {
        this.repositry = repositry;
    }

    public MutableLiveData<ArrayList<ResultsItem>> getMutableLiveData() {
        return mutableLiveData;
    }
    public void getPokemons(){
        repositry.getPokemen().subscribeOn(Schedulers.io()).map(new Function<PokemonResponse, ArrayList<ResultsItem>>() {
            @Override
            public ArrayList<ResultsItem> apply(PokemonResponse pokemonResponse) throws Throwable {
          ArrayList<ResultsItem> pokemoen= (ArrayList<ResultsItem>) pokemonResponse.getResults();
                for (ResultsItem item:pokemoen) {
                    String url=item.getUrl();
                    String[] pokemonIndex=url.split("/");
                    item.setUrl("https://pokeres.bastionbot.org/images/pokemon/"+pokemonIndex[pokemonIndex.length-1]+".png");

                }

                  return pokemoen;
            }
        }).observeOn(AndroidSchedulers.mainThread()).subscribe(result->mutableLiveData.setValue(result),error-> Log.e("rx",error.getLocalizedMessage()));
    }

}
