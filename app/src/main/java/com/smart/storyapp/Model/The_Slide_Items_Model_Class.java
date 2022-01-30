package com.smart.storyapp.Model;


public class The_Slide_Items_Model_Class {
    private String featured_text;
    private String the_caption_Title;

    public The_Slide_Items_Model_Class(String title, String hero) {
        this.the_caption_Title = title;
        this.featured_text = hero;
    }

    public String getFeatured_text() {
        return featured_text;
    }

    public void setFeatured_text(String featured_text) {
        this.featured_text = featured_text;
    }

    public String getThe_caption_Title() {
        return the_caption_Title;
    }



    public void setThe_caption_Title(String the_caption_Title) {
        this.the_caption_Title = the_caption_Title;
    }
}
