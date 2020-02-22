package com.uala.gabcast.ualachallenge.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;
import com.uala.gabcast.ualachallenge.R;
import com.uala.gabcast.ualachallenge.entitites.Meal;

public class DetalleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        Meal meal = getMealIntent();
        setResources(meal);
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

}
