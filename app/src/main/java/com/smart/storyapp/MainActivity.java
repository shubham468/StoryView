package com.smart.storyapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.smart.storyapp.Model.GetSliderData;
import com.smart.storyapp.Model.SliderDetail;
import com.smart.storyapp.Model.The_Slide_Items_Model_Class;
import com.smart.storyapp.Utils.InfinitePagerAdapter;
import com.smart.storyapp.Utils.InfiniteViewPager;
import com.smart.storyapp.ViewModel.ViewModel;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.PagerAdapter;

public class MainActivity extends AppCompatActivity implements InfiniteViewPager.OnPageChangeListener {

    private List<The_Slide_Items_Model_Class> sliderList = new ArrayList<>();
    private int dotscount;
    private ImageView[] dots;
    private InfiniteViewPager page;
    private TabLayout tabLayout;
    LinearLayout sliderDotspanel;
    ViewModel viewModel;
    CardView slider_view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewModelProvider.Factory factory = new ViewModelProvider.NewInstanceFactory();
        viewModel = new ViewModelProvider(this, factory).get(ViewModel.class);
        slider_view = findViewById(R.id.slider_view);
        sliderDotspanel = findViewById(R.id.SliderDots);
        page = findViewById(R.id.my_pager);
        tabLayout = findViewById(R.id.my_tablayout);

        viewModel.setSliderDataMutableLiveData();

        viewModel.getSliderResponseLiveData().observe(this, new Observer<GetSliderData>() {
            @Override
            public void onChanged(GetSliderData getSliderResponse) {

                sliderList.clear();
                if (getSliderResponse.getData() != null) {
                    int pos = 0;
                    for (SliderDetail str : getSliderResponse.getData()) {
                        sliderList.add(new The_Slide_Items_Model_Class(str.getId(), str.getText()));
                        pos++;
                    }
                    if (sliderList.size() != 0) {
                        slider_view.setVisibility(View.VISIBLE);
                        dotscount = 0;
                        setup_Slider();
                    } else {
                        slider_view.setVisibility(View.GONE);

                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Something went wrong...", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    private void setup_Slider() {
        PagerAdapter itemsPager_adapter = new InfinitePagerAdapter(new SliderPagerAdapter(this, sliderList));
        page.setAdapter(itemsPager_adapter);

        sliderDotspanel.removeAllViews();
        dotscount = ((InfinitePagerAdapter) itemsPager_adapter).getRealCount();
        dots = new ImageView[dotscount];

        for (int i = 0; i < dotscount; i++) {
            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.default_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(20, 20);

            params.setMargins(8, 0, 8, 0);

            sliderDotspanel.addView(dots[i], params);
        }
        dots[0].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.selected_dot));
        ((InfiniteViewPager) page).addOnPageChangeListener(this);

//        tabLayout.setupWithViewPager(page);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {
        for (int i = 0; i < dotscount; i++) {
            dots[i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.default_dot));
        }
        dots[page.getCurrentItem()].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.selected_dot));

    }
}