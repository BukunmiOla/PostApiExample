package com.example.postapiexample.network;

import com.example.postapiexample.model.NameResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DataService {
    @GET ("/tasks")
    Call<List<NameResponse>> getNames();


}
