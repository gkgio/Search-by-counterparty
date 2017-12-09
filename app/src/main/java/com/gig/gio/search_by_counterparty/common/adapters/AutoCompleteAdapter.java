package com.gig.gio.search_by_counterparty.common.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;
import android.widget.Filter;

import java.util.List;

/**
 * Created by georgy on 29.10.2017.
 * Gig
 */

public class AutoCompleteAdapter<String> extends ArrayAdapter<String> {

    private Filter filter = new KNoFilter();
    private List<String> items;

    public AutoCompleteAdapter(Context context, int resource, List<String> items) {
        super(context, resource, items);
        this.items = items;
    }

    @NonNull
    @Override
    public Filter getFilter() {
        return filter;
    }

    private class KNoFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence arg0) {
            if (!arg0.toString().trim().isEmpty()) {
                final FilterResults result = new FilterResults();
                result.values = items;
                result.count = items.size();
                return result;
            } else {
                items.clear();
                return null;
            }
        }

        @Override
        protected void publishResults(CharSequence arg0, FilterResults arg1) {
            notifyDataSetChanged();
        }
    }
}
