package com.example.postapiexample.network;

import com.example.postapiexample.model.DetailResponse;
import com.example.postapiexample.model.DetailRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface DataService {
    @GET ("/tasks")
    Call<List<DetailResponse>> getDetails();

    @POST("/tasks")
    Call<List<DetailRequest>> postDetails(@Body DetailRequest detailRequest);


}
