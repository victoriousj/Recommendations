package com.example.victor.recommendations.model;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.victor.recommendations.R;

public class ListingAdapter extends RecyclerView.Adapter<ListingAdapter.ListingHolder> {

    private LayoutInflater inflater;

    public ListingAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    @Override
    public ListingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ListingHolder(inflater.inflate(R.layout.layout_listing, parent, false));
    }

    @Override
    public void onBindViewHolder(ListingHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ListingHolder extends RecyclerView.ViewHolder {

        public ImageView mImageView;
        public TextView titleView;
        public TextView shopNameView;
        public TextView priceView;

        public ListingHolder(View itemView) {
            super(itemView);

            mImageView = itemView.findViewById(R.id.listing_image);
            titleView = itemView.findViewById(R.id.listing_title);
            shopNameView = itemView.findViewById(R.id.listing_shop_name);
            priceView = itemView.findViewById(R.id.listing_price);
        }
    }
}
