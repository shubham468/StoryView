package com.smart.storyapp.Repository;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.smart.storyapp.Model.GetSliderData;
import com.smart.storyapp.network.ApiEndpoint;
import com.smart.storyapp.network.RetroInstance;

import java.io.IOException;

import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {


    public Repository() {
    }

    private static final String TAG = "Repository";
    private static Repository instance = null;

    public static Repository getInstance() {
        if (instance == null) {
            instance = new Repository();
        }
        return instance;
    }

    public void Slider(final MutableLiveData<GetSliderData> getSliderResponseMutableLiveData) {
        ApiEndpoint apiEndpoint = RetroInstance.create(ApiEndpoint.class);
        Call<GetSliderData> call = apiEndpoint.slider();
        call.enqueue(new Callback<GetSliderData>() {
            @Override
            public void onResponse(Call<GetSliderData> call, Response<GetSliderData> response) {
                if (response.isSuccessful()) {
                    getSliderResponseMutableLiveData.setValue(response.body());
                } else {
                    Gson gson = new GsonBuilder().create();
                    GetSliderData objectiveQuestionResponse = null;
                    try {
                        objectiveQuestionResponse = gson.fromJson(response.errorBody().string(), GetSliderData.class);
                        getSliderResponseMutableLiveData.setValue(objectiveQuestionResponse);
                    } catch (IOException | JsonSyntaxException e) {
                        e.printStackTrace();
                    }
                }

            }

            @Override
            public void onFailure(Call<GetSliderData> call, Throwable t) {
                Log.d("slider_failure", t.getMessage());
            }
        });
    }



}
