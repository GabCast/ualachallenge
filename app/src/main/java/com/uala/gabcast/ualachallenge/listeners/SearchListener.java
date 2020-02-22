package com.uala.gabcast.ualachallenge.listeners;

import com.uala.gabcast.ualachallenge.entitites.Meal;

import java.util.ArrayList;

public interface SearchListener {

    void showProgress();
    void hideProgress();
    void setRecyclerView(ArrayList<Meal> meals);
    void navigateDetalle(Meal meal);
    void showRandom(Meal meal);
}
