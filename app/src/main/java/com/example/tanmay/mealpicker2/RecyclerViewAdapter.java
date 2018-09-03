package com.example.tanmay.mealpicker2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;


/**
 * Created by User on 1/1/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<Meal> meals = new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapter(Context context, ArrayList<Meal> mmeals ) {
        meals = mmeals;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");



        holder.dishname.setText(meals.get(position).dish);
        holder.restname.setText(meals.get(position).restaurant);
        holder.price.setText("$"+String.valueOf(meals.get(position).price));

        /*holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on: " + mImageNames.get(position));

                Toast.makeText(mContext, mImageNames.get(position), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(mContext, GalleryActivity.class);
                intent.putExtra("image_url", mImages.get(position));
                intent.putExtra("image_name", mImageNames.get(position));
                mContext.startActivity(intent);
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return meals.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView dishname;
        TextView restname;
        TextView price;
        RelativeLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            dishname = (TextView)itemView.findViewById(R.id.dishname);
            restname = (TextView)itemView.findViewById(R.id.restname);
            price = (TextView)itemView.findViewById(R.id.price);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}
