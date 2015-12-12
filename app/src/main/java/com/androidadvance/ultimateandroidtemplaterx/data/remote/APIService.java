package com.androidadvance.ultimateandroidtemplaterx.data.remote;

import com.androidadvance.ultimateandroidtemplaterx.data.model.Character;

import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

public interface APIService {

    String ENDPOINT = "http://swapi.co/api/";

    @GET("people/{personId}")
    Observable<Character> getCharacter(@Path("personId") int id);

}
