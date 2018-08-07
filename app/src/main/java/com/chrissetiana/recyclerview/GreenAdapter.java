package com.chrissetiana.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class GreenAdapter extends RecyclerView.Adapter<GreenAdapter.NumberViewHolder> {

    private static final String LOG_TAG = GreenAdapter.class.getSimpleName();

    private int numItems;

    GreenAdapter(int numOfItems) {
        numItems = numOfItems;
    }

    @NonNull
    @Override
    public NumberViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.number_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);

        return new NumberViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GreenAdapter.NumberViewHolder holder, int position) {
        Log.d(LOG_TAG, "#" + position);
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return numItems;
    }

    class NumberViewHolder extends RecyclerView.ViewHolder {
        TextView listItemNumberView;

        NumberViewHolder(View itemView) {
            super(itemView);
            listItemNumberView = itemView.findViewById(R.id.tv_item_number);
        }

        void bind(int listIndex) {
            listItemNumberView.setText(String.valueOf(listIndex));
        }
    }
}
