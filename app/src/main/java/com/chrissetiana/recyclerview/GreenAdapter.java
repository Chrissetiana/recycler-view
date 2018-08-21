package com.chrissetiana.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

public class GreenAdapter extends RecyclerView.Adapter<GreenAdapter.NumberViewHolder> {

    private static final String LOG_TAG = GreenAdapter.class.getSimpleName();
    private final ListItemClickListener clickListener;
    private int viewHolderCount;
    private int numItems;


    GreenAdapter(int numOfItems, ListItemClickListener listener) {
        numItems = numOfItems;
        clickListener = listener;
        viewHolderCount = 0;
    }

    @Override
    public int getItemCount() {
        return numItems;
    }

    @NonNull
    @Override
    public NumberViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        int layoutIdForListItem = R.layout.number_list_item;
        String msg = "ViewHolder index: " + viewHolderCount;

        Context context = viewGroup.getContext();
        View view = LayoutInflater.from(context).inflate(layoutIdForListItem, viewGroup, false);
        NumberViewHolder viewHolder = new NumberViewHolder(view);
        viewHolder.viewHolderIndex.setText(msg);

        int backgroundColor = ColorUtils.getViewHolderBackgroundColor(context, viewHolderCount);
        viewHolder.itemView.setBackgroundColor(backgroundColor);

        viewHolderCount++;

        Log.d(LOG_TAG, "onCreateViewHolder: number of ViewHolders created: " + viewHolderCount);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull GreenAdapter.NumberViewHolder holder, int position) {
        Log.d(LOG_TAG, "#" + position);
        holder.bind(position);
    }

    public interface ListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }

    class NumberViewHolder extends RecyclerView.ViewHolder implements OnClickListener {
        TextView listItemNumberView;
        TextView viewHolderIndex;

        NumberViewHolder(View itemView) {
            super(itemView);
            listItemNumberView = itemView.findViewById(R.id.tv_item_number);
            viewHolderIndex = itemView.findViewById(R.id.tv_view_holder_instance);
            itemView.setOnClickListener(this);
        }

        void bind(int listIndex) {
            listItemNumberView.setText(String.valueOf(listIndex));
        }

        @Override
        public void onClick(View view) {
            int clickedPosition = getAdapterPosition();
            clickListener.onListItemClick(clickedPosition);
        }
    }
}
