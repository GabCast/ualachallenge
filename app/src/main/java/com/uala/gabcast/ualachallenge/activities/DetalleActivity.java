package com.uala.gabcast.ualachallenge.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.gson.Gson;
import com.uala.gabcast.ualachallenge.R;
import com.uala.gabcast.ualachallenge.adapters.MealsRecyclerAdapter;
import com.uala.gabcast.ualachallenge.adapters.StringGenericoRecyclerAdapter;
import com.uala.gabcast.ualachallenge.entitites.Meal;

import java.util.ArrayList;

public class DetalleActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener{

    private Meal meal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        meal = getMealIntent();
        setResources();
        setRecyclerView();

    }

    private Meal getMealIntent(){
        String a = getIntent().getStringExtra("meal");
        return new Gson().fromJson(a, Meal.class);
    }

    private void setResources(){
        TextView txtNombre = (TextView) findViewById(R.id.txtNombre);
        txtNombre.setText(meal.getStrMeal());
        TextView txtInstrucciones = (TextView) findViewById(R.id.txtInstrucciones);
        txtInstrucciones.setText(meal.getStrInstructions());
        YouTubePlayerView youtube = (YouTubePlayerView) findViewById(R.id.youtube);
        youtube.initialize(getResources().getString(R.string.Youtube), this);
    }


    public void setRecyclerView() {
        RecyclerView rcvIngredientes = (RecyclerView) findViewById(R.id.rcvIngredientes) ;
        GridLayoutManager lLayout = new GridLayoutManager(this, 2);
        rcvIngredientes.setHasFixedSize(true);
        rcvIngredientes.setLayoutManager(lLayout);
        StringGenericoRecyclerAdapter rcAdapter = new StringGenericoRecyclerAdapter(meal.getIngredientes());
        rcvIngredientes.setAdapter(rcAdapter);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        if (!b) {
            String[] url = meal.getStrYoutube().split("=");
            youTubePlayer.cueVideo(url[1]);
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

    }
}
