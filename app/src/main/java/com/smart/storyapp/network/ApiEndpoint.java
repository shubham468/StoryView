package com.smart.storyapp.network;


import com.smart.storyapp.Model.GetSliderData;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiEndpoint {

    @GET("/fjaqJ")
    Call<GetSliderData> slider();


}
