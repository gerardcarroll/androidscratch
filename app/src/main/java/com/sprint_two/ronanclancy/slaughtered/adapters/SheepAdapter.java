package com.sprint_two.ronanclancy.slaughtered.adapters;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.sprint_two.ronanclancy.slaughtered.R;
import com.sprint_two.ronanclancy.slaughtered.models.Sheep;

import java.util.List;
//cows are nicer
/**
 * Sheep adapter
 * <p/>
 * Created by ronanclancy on 1/13/16.
 */
public class SheepAdapter extends RecyclerView.Adapter<SheepAdapter.SheepViewHolder> {

    int lastPosition = -1;

    List<Sheep> sheeps;

    Context context;

    public SheepAdapter(List<Sheep> sheeps, Context context) {
        this.sheeps = sheeps;
        this.context = context;
    }

    @Override
    public SheepViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sheep_item, parent, false);
        return new SheepViewHolder(view);
    }

    /**
     * Called by RecyclerView to display the data at the specified position
     *
     * @param holder   Sheep view holder
     * @param position Position of sheep in list
     */
    @Override
    public void onBindViewHolder(SheepViewHolder holder, final int position) {
        holder.sheepName.setText(sheeps.get(position).name);
        holder.sheepAge.setText(sheeps.get(position).age);
        holder.sheepWeight.setText(sheeps.get(position).weight);
        holder.sheepPhoto.setImageResource(sheeps.get(position).photoId);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, sheeps.get(position).name + " is lucky slaughter implementation is not complete", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        setAnimation(holder.itemView, position);
    }

    /**
     * Returns the total number of items in the data set hold by the adapter.
     *
     * @return int list size
     */
    @Override
    public int getItemCount() {
        return sheeps.size();
    }

    /**
     * Called by RecyclerView when it starts observing this Adapter.
     * Keep in mind that same adapter may be observed by multiple RecyclerViews.
     *
     * @param recyclerView Sheep list RecycleView
     */
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public class SheepViewHolder extends RecyclerView.ViewHolder {

        RecyclerView recyclerView;
        TextView sheepName;
        TextView sheepAge;
        TextView sheepWeight;
        ImageView sheepPhoto;

        SheepViewHolder(final View itemView) {
            super(itemView);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.sheep_recycler_view);
            sheepName = (TextView) itemView.findViewById(R.id.sheep_name);
            sheepAge = (TextView) itemView.findViewById(R.id.sheep_age);
            sheepWeight = (TextView) itemView.findViewById(R.id.sheep_weight);
            sheepPhoto = (ImageView) itemView.findViewById(R.id.sheep_photo);
            setupPrefs(sheepName);
        }
    }

    /**
     * To be extracted
     *
     * @param sheepNameTextView Sheep Name
     */
    private void setupPrefs(TextView sheepNameTextView) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        Boolean fontPref = prefs.getBoolean("change_font_key", false);

        if (fontPref) {
            sheepNameTextView.setTextSize(24);
        } else {
            sheepNameTextView.setTextSize(18);
        }
    }

    /**
     * Animate View
     *
     * @param viewToAnimate View to animate
     */
    private void setAnimation(View viewToAnimate, int position) {
        if (position > lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(context, R.anim.slide);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }
}

