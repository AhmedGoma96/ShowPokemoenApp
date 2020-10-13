package com.example.showpokemoenapp;



import com.example.showpokemoenapp.Api.PokemenService;
import com.example.showpokemoenapp.Model.PokemonResponse;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;

public class Repositry {
    private PokemenService pokemenService;

    @Inject
    public Repositry(PokemenService pokemenService) {
        this.pokemenService = pokemenService;
    }

    public Observable<PokemonResponse> getPokemen() {
        return pokemenService.getPekemoen();
    }
}
