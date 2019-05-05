package com.example.resepmasak;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import static android.support.constraint.Constraints.TAG;

public class HomePageAdapter extends RecyclerView.Adapter<HomePageAdapter.ViewHolder> {

    private ArrayList<String> judulResep = new ArrayList<>();
    private ArrayList<String> photoResep = new ArrayList<>();
    private Context mContext;

    public HomePageAdapter(Context mContext, ArrayList<String> judulResep, ArrayList<String> photoResep) {
        this.judulResep = judulResep;
        this.photoResep = photoResep;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public HomePageAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_kategori,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomePageAdapter.ViewHolder holder, final int position) {

        Log.d(TAG, "onBindViewHolder: called : "+ judulResep.get(position));

        Glide.with(mContext)
                .asBitmap()
                .load(photoResep.get(position))
                .into(holder.photonya);


        holder.judulnya.setText(judulResep.get(position));

        holder.CardViewparent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, judulResep.get(position), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return judulResep.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView photonya;
        TextView judulnya;
        CardView CardViewparent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            judulnya = itemView.findViewById(R.id.judulnya);
            photonya = itemView.findViewById(R.id.photonya);
            CardViewparent = itemView.findViewById(R.id.card_view_parent);

        }
    }


}
