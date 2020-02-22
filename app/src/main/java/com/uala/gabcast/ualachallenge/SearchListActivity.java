package com.uala.gabcast.ualachallenge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.uala.gabcast.ualachallenge.adapters.MealsRecyclerAdapter;
import com.uala.gabcast.ualachallenge.entitites.Meal;
import com.uala.gabcast.ualachallenge.presenter.SearchListPresenter;

import java.util.ArrayList;

public class SearchListActivity extends AppCompatActivity implements SearchListener {

    private ProgressBar pbMeals;
    private TextView txtSearch;
    private SearchListPresenter searchListPresenter = new SearchListPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
}
