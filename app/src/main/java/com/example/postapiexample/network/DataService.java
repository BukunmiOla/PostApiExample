package com.example.postapiexample.network;

import com.example.postapiexample.model.DetailResponse;
import com.example.postapiexample.model.DetailRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface DataService {
    @GET ("/tasks")
    Call<List<DetailResponse>> getDetails();

    @POST("/tasks")
    Call<List<DetailRequest>> postDetails(@Body DetailRequest detailRequest);

    @GET("/tasks/{id}")
    Call<DetailResponse> getById(@Path("id") String id);

    @PUT("/tasks/{id}")
    Call<DetailResponse> updateById(@Path("id") String id, @Body DetailRequest detailRequest);

    @DELETE("/tasks/{id}")
    Call<DetailResponse> deleteById(@Path("id") String id);

    @DELETE("/tasks")
    Call<List<DetailResponse>> deleteAll();
}
