package com.smart.storyapp.ViewModel;


import com.smart.storyapp.Model.GetSliderData;
import com.smart.storyapp.Repository.Repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class ViewModel extends androidx.lifecycle.ViewModel {
    private Repository repository = Repository.getInstance();

    private MutableLiveData<GetSliderData> getSliderDataMutableLiveData  =new MutableLiveData<>();

    public LiveData<GetSliderData>  getSliderResponseLiveData(){
        return getSliderDataMutableLiveData ;
    }
    public void setSliderDataMutableLiveData(){
        repository.Slider(getSliderDataMutableLiveData);
    }

}
