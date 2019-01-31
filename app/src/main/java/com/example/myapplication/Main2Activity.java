package com.example.myapplication;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.github.florent37.materialviewpager.MaterialViewPager;
import com.github.florent37.materialviewpager.header.HeaderDesign;

import java.util.Objects;

public class Main2Activity extends AppCompatActivity {
    private MaterialViewPager mViewPager;
    static final int TAPS = 2;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mViewPager = findViewById(R.id.materialViewPager);
        FloatingActionButton floatingActionButton = findViewById(R.id.fab111);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Main2Activity.this, Main4Activity.class);
                startActivity(intent);
            }
        });
        mViewPager.setMaterialViewPagerListener(new MaterialViewPager.Listener() {
            @Override
            public HeaderDesign getHeaderDesign(int page) {
                switch (page) {
                    case 0:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.blue,
                                GetImage.getRandImageUrl());
                    case 1:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.green,
                                GetImage.getRandImageUrl());
                }
                return null;
            }
        });


        mViewPager.getViewPager().setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                switch (position % TAPS) {
                    case 0:
                        return BlankFragment.newInstance();
                    default:
                        return RecyclerViewFragment.newInstance();
                }
            }

            @Override
            public int getCount() {
                return TAPS;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position % TAPS) {
                    case 0:
                        return "赞美诗";
                    default:
                        return "诗歌集";
                }
            }
        });
        //设置setViewPager
        mViewPager.getViewPager().setOffscreenPageLimit(Objects.requireNonNull(mViewPager.getViewPager().getAdapter()).getCount());
        mViewPager.getPagerTitleStrip().setViewPager(mViewPager.getViewPager());


    }

    /**
     * @return
     */



    @Override
    protected void onDestroy() {
        super.onDestroy();
        Intent intent = new Intent( Main2Activity.this, MusicService.class );
        SharedPreferences.Editor editor =getSharedPreferences("isPlaying",MODE_PRIVATE).edit();
        editor.putInt("isPlaying",0);
        editor.apply();
        stopService(intent);
    }

}
