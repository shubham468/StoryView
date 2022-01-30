package com.smart.storyapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.smart.storyapp.Model.The_Slide_Items_Model_Class;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class SliderPagerAdapter extends PagerAdapter {
    private Context Mcontext;
    private List<The_Slide_Items_Model_Class> theSlideItemsModelClassList;
    private ProgressBar progressBar;

    public SliderPagerAdapter(Context Mcontext, List<The_Slide_Items_Model_Class> theSlideItemsModelClassList) {
        this.Mcontext = Mcontext;
        this.theSlideItemsModelClassList = theSlideItemsModelClassList;
    }

    @SuppressLint("SetTextI18n")
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        LayoutInflater inflater = (LayoutInflater) Mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View sliderLayout = inflater.inflate(R.layout.slider_view_layout, null);

        TextView caption_title = sliderLayout.findViewById(R.id.my_caption_title);

        if (theSlideItemsModelClassList.get(position).getFeatured_text().length() != 0 &&
                theSlideItemsModelClassList.get(position).getThe_caption_Title().length() != 0)
            caption_title.setText(theSlideItemsModelClassList.get(position).getThe_caption_Title() + ". " + theSlideItemsModelClassList.get(position).getFeatured_text());


        container.addView(sliderLayout);


        return sliderLayout;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        if (theSlideItemsModelClassList.size() != 0)
            return theSlideItemsModelClassList.size();
        else
            return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }
}
