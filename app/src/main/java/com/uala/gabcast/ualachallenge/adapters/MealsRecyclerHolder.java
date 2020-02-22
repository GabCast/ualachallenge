package com.uala.gabcast.ualachallenge.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.uala.gabcast.ualachallenge.R;

public class MealsRecyclerHolder extends  RecyclerView.ViewHolder {


    public View viewItem;
    public TextView txtNombre, txtCategoria;
    public ImageView imgPlato;

    public MealsRecyclerHolder(View itemView) {
        super(itemView);
        viewItem = itemView;
        txtNombre = (TextView) itemView.findViewById(R.id.txtNombre);
        txtCategoria = (TextView) itemView.findViewById(R.id.txtCategoria);
        imgPlato = (ImageView) itemView.findViewById(R.id.imgPlato);
    }
}
