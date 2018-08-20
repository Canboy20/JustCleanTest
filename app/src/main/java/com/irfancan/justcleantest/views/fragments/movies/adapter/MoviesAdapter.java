package com.irfancan.justcleantest.views.fragments.movies.adapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.irfancan.justcleantest.R;
import com.irfancan.justcleantest.models.MoviesResponse;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {
    private List<MoviesResponse> values;



    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtHeader;
        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            txtHeader = v.findViewById(R.id.movie_title_textView);
        }
    }

    public void add(int position, MoviesResponse item) {
        values.add(position, item);
        notifyItemInserted(position);
    }



    public MoviesAdapter(List<MoviesResponse> myDataset) {
        values = myDataset;
    }


    // Creates new views
    @Override
    public MoviesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {
        // create  new view
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.movie_list_row, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;

    }



    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        //Text on views will be updated according to position
        final String name = values.get(position).getTitle();
        holder.txtHeader.setText(name);


    }

    @Override
    public int getItemCount() {

        return values.size();
    }

}
