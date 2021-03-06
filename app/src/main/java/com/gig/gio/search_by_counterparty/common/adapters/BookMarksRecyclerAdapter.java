package com.gig.gio.search_by_counterparty.common.adapters;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gig.gio.search_by_counterparty.R;
import com.gig.gio.search_by_counterparty.common.eventbus.Bus;
import com.gig.gio.search_by_counterparty.common.eventbus.events.bookmarks.SuggestResponseAdapterEvent;
import com.gig.gio.search_by_counterparty.model.SuggestResponse;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by georgy on 05.11.2017.
 * Gig
 */

public class BookMarksRecyclerAdapter extends RecyclerView.Adapter<BookMarksRecyclerAdapter.BookMarksItemViewHolder> {

    private List<SuggestResponse> suggestResponseRealmList;
    private Bus bus;

    public BookMarksRecyclerAdapter() {
        this.suggestResponseRealmList = new ArrayList<>();
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    @Override
    public BookMarksRecyclerAdapter.BookMarksItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book_marks, parent, false);
        return new BookMarksItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BookMarksItemViewHolder holder, int position) {

        final SuggestResponse suggestResponse = getSuggestResponse(position);
        if (suggestResponse.isBookmark()) {
            holder.ivStar.setVisibility(View.VISIBLE);
        } else {
            holder.ivStar.setVisibility(View.INVISIBLE);
        }
        holder.tvValue.setText(suggestResponse.getValue());

        holder.itemView.setBackgroundColor(ContextCompat.
                getColor(holder.itemView.getContext(), position % 2 == 0 ? R.color.row_odd : R.color.row_even));

        holder.itemView.setOnClickListener(v -> bus.send(new SuggestResponseAdapterEvent(suggestResponse)));
    }

    @Override
    public int getItemCount() {
        return suggestResponseRealmList.size();
    }

    private SuggestResponse getSuggestResponse(int position) {
        return suggestResponseRealmList.get(position);
    }

    public void setValues(List<SuggestResponse> suggests) {
        this.suggestResponseRealmList = suggests;
        notifyDataSetChanged();
    }

    // view holder class ======================
    class BookMarksItemViewHolder extends RecyclerView.ViewHolder {

        final TextView tvValue;
        final ImageView ivStar;

        public BookMarksItemViewHolder(View itemView) {
            super(itemView);
            tvValue = itemView.findViewById(R.id.tvValue);
            ivStar = itemView.findViewById((R.id.ivStar));
        }
    }
}
