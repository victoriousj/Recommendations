package com.example.victor.recommendations.model;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

public class ListingAdapter extends RecyclerView.Adapter<ListingAdapter.ListingHolder> {

    @Override
    public ListingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ListingHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ListingHolder extends RecyclerView.ViewHolder {

        public ListingHolder(View itemView) {
            super(itemView);
        }
    }
}
