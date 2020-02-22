package com.uala.gabcast.ualachallenge.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;
import com.uala.gabcast.ualachallenge.R;
import com.uala.gabcast.ualachallenge.adapters.MealsRecyclerAdapter;
import com.uala.gabcast.ualachallenge.adapters.StringGenericoRecyclerAdapter;
import com.uala.gabcast.ualachallenge.entitites.Meal;

import java.util.ArrayList;

public class DetalleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        Meal meal = getMealIntent();
        setResources(meal);
        setRecyclerView(meal);
    }

    private Meal getMealIntent(){
        String a = getIntent().getStringExtra("meal");
        return new Gson().fromJson(a, Meal.class);
    }

    private void setResources(Meal meal){
        TextView txtNombre = (TextView) findViewById(R.id.txtNombre);
        txtNombre.setText(meal.getStrMeal());
        TextView txtInstrucciones = (TextView) findViewById(R.id.txtInstrucciones);
        txtInstrucciones.setText(meal.getStrInstructions());
    }


    public void setRecyclerView(Meal meal) {
        RecyclerView rcvIngredientes = (RecyclerView) findViewById(R.id.rcvIngredientes) ;
        GridLayoutManager lLayout = new GridLayoutManager(this, 2);
        rcvIngredientes.setHasFixedSize(true);
        rcvIngredientes.setLayoutManager(lLayout);
        StringGenericoRecyclerAdapter rcAdapter = new StringGenericoRecyclerAdapter(meal.getIngredientes());
        rcvIngredientes.setAdapter(rcAdapter);
    }

}
