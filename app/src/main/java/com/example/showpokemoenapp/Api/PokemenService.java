package com.example.showpokemoenapp.Api;


import com.example.showpokemoenapp.Model.PokemonResponse;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface PokemenService {
    @GET("pokemon")
    Observable<PokemonResponse> getPekemoen();
}
