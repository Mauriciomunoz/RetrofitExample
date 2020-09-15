package com.mapp.retrofitexample;

import com.mapp.retrofitexample.model.CompanyData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EndpointsQueries {
    @GET("/notes")
    Call<List<CompanyData>> getAllCompanies();
}
