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

public class MealsRecyclerAdapter extends RecyclerView.Adapter<MealsRecyclerHolder>  {

    private ArrayList<Meal> mealArrayList;
    private SearchListener searchListener;
    private Context context;

    public MealsRecyclerAdapter(Context context, ArrayList<Meal> mealArrayList) {
        this.mealArrayList = mealArrayList;
        this.context = context;
        this.searchListener = (SearchListener) context;
    }

    @NonNull
    @Override
    public MealsRecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_meal, null);
        return new MealsRecyclerHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MealsRecyclerHolder holder, final int position) {
        holder.txtNombre.setText(mealArrayList.get(position).getStrMeal());
        holder.txtCategoria.setText(mealArrayList.get(position).getStrCategory());

        holder.itemView.setOnClickListener(v -> searchListener.navigateDetalle(mealArrayList.get(position)));

        PicassoTrustAll.getInstance(context)
                .load(mealArrayList.get(position).getStrMealThumb())
                .rotate(90f)
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                .networkPolicy(NetworkPolicy.NO_CACHE)
                .into(holder.imgPlato, new Callback() {
                    @Override
                    public void onSuccess() {
                    }

                    @Override
                    public void onError() {
                    }
                });

    }

    @Override
    public int getItemCount() {
        return this.mealArrayList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

}