package com.uala.gabcast.ualachallenge.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.uala.gabcast.ualachallenge.R;

public class StringGenericoRecyclerHolder extends  RecyclerView.ViewHolder {


    public View viewItem;
    public TextView txtString;

    public StringGenericoRecyclerHolder(View itemView) {
        super(itemView);
        viewItem = itemView;
        txtString = (TextView) itemView.findViewById(R.id.txtString);
    }
}
