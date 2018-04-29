package com.example.victor.recommendations.api;

import com.example.victor.recommendations.model.ActiveListings;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

public interface Api {

    @GET("/listings/active")
    void activeListings(@Query("includes") String includes, Callback<ActiveListings> callback);
}
