package com.example.tanmay.mealpicker2;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.solver.widgets.Snapshot;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class Generate_Meal extends AppCompatActivity {

    Map<String,Meal> datamap;
    Map<String,Meal> valuemap;
    ProgressBar progressBar;


    ArrayList<Meal> meal_list = new ArrayList<Meal>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meal_generate);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("Meals");

        databaseReference.addValueEventListener(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        meal_list.clear();
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            Meal mealin = snapshot.getValue(Meal.class);
                            System.out.println(mealin);
                            meal_list.add(mealin);

                        }



                        for(Meal m: meal_list)
                        {
                            System.out.println(m.dish);
                        }
                        int index = (int)(Math.random()*meal_list.size());
                        System.out.println("WTF "+index+"  List Size:"+meal_list.size());
                        Meal meal = (Meal)meal_list.get(index);
                        TextView dishname = (TextView ) findViewById(R.id.textView4);
                        TextView restname = (TextView ) findViewById(R.id.textView5);
                        TextView cost = (TextView ) findViewById(R.id.textView6);
                        dishname.append(meal.dish);
                        restname.append(meal.restaurant);
                        cost.append(String.valueOf(meal.price));

                        progressBar.setVisibility(View.GONE);




                    }

                        @Override
                        public void onCancelled(DatabaseError databaseError){
                            //handle databaseError
                        }


                });





        Button back = findViewById(R.id.button4);

        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                // back to Menu
                Intent switchact =new Intent(getApplicationContext(),MainActivity.class);
                startActivity(switchact);
            }
        });

    }
}
