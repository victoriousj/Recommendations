package com.example.victor.recommendations.api;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;

public class Etsy {
    public static final String API_KEY = "wyveeswssdta0cainwje1nhi";

    private static RequestInterceptor getInterceptor() {
        return new RequestInterceptor() {

            @Override
            public void intercept(RequestFacade request) {
                request.addEncodedQueryParam("api_key", API_KEY);
            }
        }
    }

    private static Api getApi() {
        return new RestAdapter.Builder()
                .setEndpoint("https://openapi.etsy.com/vs")
                .setRequestInterceptor(getInterceptor())
                .build()
                .create(Api.class);
    }
}
