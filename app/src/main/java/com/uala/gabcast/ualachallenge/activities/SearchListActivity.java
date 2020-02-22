package com.uala.gabcast.ualachallenge.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.gson.Gson;
import com.uala.gabcast.ualachallenge.R;
import com.uala.gabcast.ualachallenge.adapters.MealsRecyclerAdapter;
import com.uala.gabcast.ualachallenge.entitites.Meal;
import com.uala.gabcast.ualachallenge.listeners.SearchListener;
import com.uala.gabcast.ualachallenge.presenter.SearchListPresenter;

import java.util.ArrayList;

public class SearchListActivity extends AppCompatActivity implements SearchListener {

    private ProgressBar pbMeals;
    private TextView txtSearch;
    private SearchListPresenter searchListPresenter = new SearchListPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        setResources();
        searchListPresenter.searchListBy("");
    }

    private void setResources(){
        pbMeals = (ProgressBar) findViewById(R.id.pbMeals);
        txtSearch = (TextView) findViewById(R.id.txtSearch);
        txtSearchChangeListener();
    }

    private void txtSearchChangeListener(){
        txtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                searchListPresenter.searchListBy(txtSearch.getText().toString());
            }
        });
    }



    @Override
    public void showProgress() {
        pbMeals.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        pbMeals.setVisibility(View.GONE);
    }

    @Override
    public void setRecyclerView(ArrayList<Meal> meals) {
        RecyclerView rcvMeals = (RecyclerView) findViewById(R.id.rcvMeals) ;
        GridLayoutManager lLayout = new GridLayoutManager(this, 1);
        rcvMeals.setHasFixedSize(true);
        rcvMeals.setLayoutManager(lLayout);
        MealsRecyclerAdapter rcAdapter = new MealsRecyclerAdapter(this, meals);
        rcvMeals.setAdapter(rcAdapter);
    }

    @Override
    public void navigateDetalle(Meal meal) {
        Intent intent = new Intent(this, DetalleActivity.class);
        intent.putExtra("meal", new Gson().toJson(meal));
        startActivity(intent);
    }
}
