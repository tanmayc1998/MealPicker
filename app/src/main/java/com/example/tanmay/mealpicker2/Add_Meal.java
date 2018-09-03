package com.example.tanmay.mealpicker2;

import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Add_Meal extends AppCompatActivity {
    EditText cost;
    EditText restname;
    EditText dishname;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__meal);

        dishname = (EditText) findViewById(R.id.dishname);
        restname = (EditText) findViewById(R.id.restname);
        cost = (EditText) findViewById(R.id.cost);
        Button add_it = (Button) findViewById(R.id.add_it);

        add_it.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //adding meal
                addMeal();
            }
        });


    }


    public void addMeal()
    {
        Meal newmeal = new Meal();
        newmeal.dish = String.valueOf(dishname.getText());
        newmeal.restaurant = String.valueOf(restname.getText());
        newmeal.price = Double.parseDouble(String.valueOf(cost.getText()));
        Log.i("Object Details",newmeal.dish+" "+newmeal.restaurant);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        DatabaseReference mealsref = mDatabase.child("Meals");
        DatabaseReference newmealref = mealsref.push();
        newmealref.setValue(newmeal);
        Intent switchact =new Intent(getApplicationContext(),MainActivity.class);
        startActivity(switchact);



    }
}
