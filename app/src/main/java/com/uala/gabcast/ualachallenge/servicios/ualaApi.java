package com.uala.gabcast.ualachallenge.servicios;


import com.uala.gabcast.ualachallenge.entitites.Meals;


import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface ualaApi {
    @GET("api/json/v1/1/search.php")
    Observable<Meals> searchList(@Query("s") String s);

}