package com.example.tanmay.mealpicker2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tanmay.mealpicker2.R;

public class MainActivity extends AppCompatActivity {

    Button genMeal;
    Button addMeal;
    Button seeMeals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        genMeal = (Button)findViewById(R.id.button);
        addMeal = (Button)findViewById(R.id.button2);
        seeMeals = (Button)findViewById(R.id.button3);

        genMeal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                // starting background task to update product
                Intent switchact =new Intent(getApplicationContext(),Generate_Meal.class);
                startActivity(switchact);
            }
        });

        addMeal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                // starting background task to update product
                Intent switchact =new Intent(getApplicationContext(),Add_Meal.class);
                startActivity(switchact);
            }
        });

        seeMeals.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                // starting background task to update product
                Intent switchact =new Intent(getApplicationContext(),See_All_Meals.class);
                startActivity(switchact);
            }
        });


    }
}
