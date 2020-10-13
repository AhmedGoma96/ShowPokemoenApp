package com.example.showpokemoenapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.showpokemoenapp.Model.ResultsItem;


import java.util.ArrayList;
import java.util.List;


public class PokemoenAdapter extends RecyclerView.Adapter<PokemoenAdapter.PokemoenViewHolder> {
    private List<ResultsItem> pokemoenList = new ArrayList<>();
    private Context mContext;

    public PokemoenAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public PokemoenViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PokemoenViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.pokemoen_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PokemoenViewHolder holder, int position) {
                holder.pokemoenText.setText(pokemoenList.get(position).getName());
        Glide.with(mContext).load(pokemoenList.get(position).getUrl()).into(holder.pokemoenImage);
    }

    @Override
    public int getItemCount() {
        return pokemoenList.size();
    }

    public void setList(List<ResultsItem> pokemoenList) {
        this.pokemoenList = pokemoenList;
        notifyDataSetChanged();
    }

    public class PokemoenViewHolder extends RecyclerView.ViewHolder {
        ImageView pokemoenImage;
        TextView pokemoenText;

        public PokemoenViewHolder(@NonNull View itemView) {
            super(itemView);
            pokemoenImage=itemView.findViewById(R.id.pokemoem_image_view);
            pokemoenText=itemView.findViewById(R.id.pokemoen_text_view);

        }
    }
}
