package com.uala.gabcast.ualachallenge.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.uala.gabcast.ualachallenge.R;
import com.uala.gabcast.ualachallenge.entitites.Meal;
import com.uala.gabcast.ualachallenge.listeners.SearchListener;
import com.uala.gabcast.ualachallenge.picasso.PicassoTrustAll;

import java.util.ArrayList;

public class StringGenericoRecyclerAdapter extends RecyclerView.Adapter<StringGenericoRecyclerHolder>  {

    private ArrayList<String> strings;

    public StringGenericoRecyclerAdapter(ArrayList<String> strings) {
        this.strings = strings;
    }

    @NonNull
    @Override
    public StringGenericoRecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_string, null);
        return new StringGenericoRecyclerHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull final StringGenericoRecyclerHolder holder, final int position) {
        if (strings.get(position) != null) {
            if (!strings.get(position).equals(""))
                holder.txtString.setText(strings.get(position));
        }

    }

    @Override
    public int getItemCount() {
        return this.strings.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

}