package com.example.tanmay.mealpicker2;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class See_All_Meals extends AppCompatActivity {

    RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList<Meal> meals = new ArrayList<>();
    private static final String TAG = "See_All_Meals";
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see__all__meals);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);
        getMeals();





    }

    public void getMeals() {

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("Meals");

        databaseReference.addValueEventListener(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        meals.clear();
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            Meal mealin = snapshot.getValue(Meal.class);
                            meals.add(mealin);

                        }


                        Log.i(TAG, "onCreateInside: "+meals);
                        mRecyclerView = findViewById(R.id.RView);

                        mRecyclerView.setHasFixedSize(true);

                        // use a linear layout manager
                        mLayoutManager = new LinearLayoutManager(getApplicationContext());
                        mRecyclerView.setLayoutManager(mLayoutManager);


                        Log.i(TAG, "onCreate: "+meals);
                        // specify an adapter (see also next example)
                        mAdapter = new RecyclerViewAdapter(getApplicationContext(),meals);
                        mRecyclerView.setAdapter(mAdapter);


                        progressBar.setVisibility(View.GONE);


                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError){
                        //handle databaseError
                    }


                });


    }
}
