package com.mahak.pwa_service;

// ApiService.java
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
    @GET("data")
    Call<DataResponse> getData();

    @POST("data")
    Call<Void> sendData(@Body DataRequest data);
}

