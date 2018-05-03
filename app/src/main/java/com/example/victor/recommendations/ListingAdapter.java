package com.example.victor.recommendations;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.victor.recommendations.model.ActiveListings;
import com.example.victor.recommendations.model.Listing;
import com.squareup.picasso.Picasso;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class ListingAdapter extends RecyclerView.Adapter<ListingAdapter.ListingHolder>
implements Callback<ActiveListings> {

    private LayoutInflater inflater;
    private ActiveListings activeListings;
    private MainActivity activity;

    public ListingAdapter(MainActivity activity) {
        this.activity = activity;
        inflater = LayoutInflater.from(activity);
    }

    @Override
    public ListingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ListingHolder(inflater.inflate(R.layout.layout_listing, parent, false));
    }

    @Override
    public void onBindViewHolder(ListingHolder holder, int position) {
        final Listing listing = activeListings.results[position];
        holder.titleView.setText(listing.title);
        holder.priceView.setText(listing.price);
        holder.shopNameView.setText(listing.Shop.shop_name);
        Picasso.with(holder.mImageView.getContext())
                .load(listing.Images[0].url_570xN)
                .into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        if (activeListings == null) {
            return 0;
        }
        if (activeListings.results == null) {
            return 0;
        }

        return activeListings.results.length;
    }

    @Override
    public void success(ActiveListings activeListings, Response response) {
        this.activeListings = activeListings;
        notifyDataSetChanged();
        this.activity.showList();
    }

    @Override
    public void failure(RetrofitError error) {
        Toast.makeText(activity.getBaseContext(), "asdf", Toast.LENGTH_SHORT).show();
    }

    public ActiveListings getActiveListings() {
        return activeListings;
    }

    public class ListingHolder extends RecyclerView.ViewHolder {

        ImageView mImageView;
        TextView titleView;
        TextView shopNameView;
        TextView priceView;

        ListingHolder(View itemView) {
            super(itemView);

            mImageView = itemView.findViewById(R.id.listing_image);
            titleView = itemView.findViewById(R.id.listing_title);
            shopNameView = itemView.findViewById(R.id.listing_shop_name);
            priceView = itemView.findViewById(R.id.listing_price);
        }
    }
}
