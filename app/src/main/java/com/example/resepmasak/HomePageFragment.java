package com.example.resepmasak;


import android.content.Context;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static android.support.constraint.Constraints.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomePageFragment extends Fragment{
    private ArrayList<String> judulresep = new ArrayList<>();
    private ArrayList<String> photoresep = new ArrayList<>();
    public HomePageFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home_page, container, false);
        judulresep = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.judul)));
        photoresep = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.gambar)));

        HomePageAdapter adapter = new HomePageAdapter(getActivity(), judulresep, photoresep);
        //Linear
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL,false);
        RecyclerView recyclerView = v.findViewById(R.id.rv_homepage);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        //Grid
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(getActivity(), 2);
        RecyclerView recyclerView1 = v.findViewById(R.id.rv_homepage2);
        recyclerView1.setLayoutManager(mGridLayoutManager);
        recyclerView1.setAdapter(adapter);
        return v;
    }
}
