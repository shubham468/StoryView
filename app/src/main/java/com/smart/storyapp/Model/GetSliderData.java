
package com.smart.storyapp.Model;

import java.util.List;
import com.google.gson.annotations.Expose;

public class GetSliderData {

    @Expose
    private List<SliderDetail> data;

    public List<SliderDetail> getData() {
        return data;
    }

    public void setData(List<SliderDetail> data) {
        this.data = data;
    }

}
