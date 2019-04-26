package com.example.astronout.sliderview;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.astronout.sliderview.sliders.FragmentSlider;
import com.example.astronout.sliderview.sliders.SliderIndicator;
import com.example.astronout.sliderview.sliders.SliderPagerAdapter;
import com.example.astronout.sliderview.sliders.SliderView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SliderPagerAdapter mAdapter;
    private SliderIndicator mIndicator;

    private SliderView sliderView;
    private LinearLayout mLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sliderView = findViewById(R.id.sliderView);
        mLinearLayout = findViewById(R.id.pagesContainer);
        setupSlider();
    }


    private void setupSlider() {
        sliderView.setDurationScroll(800);
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(FragmentSlider.newInstance("http://www.menucool.com/slider/prod/image-slider-1.jpg"));
        fragments.add(FragmentSlider.newInstance("http://www.menucool.com/slider/prod/image-slider-2.jpg"));
        fragments.add(FragmentSlider.newInstance("http://www.menucool.com/slider/prod/image-slider-3.jpg"));
        fragments.add(FragmentSlider.newInstance("http://www.menucool.com/slider/prod/image-slider-4.jpg"));

        mAdapter = new SliderPagerAdapter(getSupportFragmentManager(), fragments);
        sliderView.setAdapter(mAdapter);
        mIndicator = new SliderIndicator(this, mLinearLayout, sliderView, R.drawable.indicator_circle);
        mIndicator.setPageCount(fragments.size());
        mIndicator.show();
    }
}