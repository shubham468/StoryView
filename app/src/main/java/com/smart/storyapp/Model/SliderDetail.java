
package com.smart.storyapp.Model;

import com.google.gson.annotations.Expose;


public class SliderDetail {

    @Expose
    private String id;
    @Expose
    private String text;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
