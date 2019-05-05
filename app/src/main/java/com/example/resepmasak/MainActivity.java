package com.example.resepmasak;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    ViewFlipper v_flipper;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    HomePageFragment satu = new HomePageFragment();
                    FragmentManager FM = getSupportFragmentManager();
                    FragmentTransaction FT = FM.beginTransaction();
                    FT.replace(R.id.frameLayout, satu);
                    FT.commit();
                    return true;
                case R.id.navigation_category:
                    KategoriFragment dua = new KategoriFragment();
                    FragmentManager FM2 = getSupportFragmentManager();
                    FragmentTransaction FT2 = FM2.beginTransaction();
                    FT2.replace(R.id.frameLayout, dua);
                    FT2.commit();
                    return true;
                case R.id.navigation_search:
                    SearchFragment tiga = new SearchFragment();
                    FragmentManager FM3= getSupportFragmentManager();
                    FragmentTransaction FT3 = FM3.beginTransaction();
                    FT3.replace(R.id.frameLayout, tiga);
                    FT3.commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
