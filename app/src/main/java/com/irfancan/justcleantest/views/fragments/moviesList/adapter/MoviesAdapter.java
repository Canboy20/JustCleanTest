package com.irfancan.justcleantest.views.fragments.moviesList.adapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.irfancan.justcleantest.R;
import com.irfancan.justcleantest.constants.Constants;
import com.irfancan.justcleantest.models.MoviesResponse;
import com.irfancan.justcleantest.views.fragments.detailsList.MovieDetailsFragment;

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
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        //Text on views will be updated according to position
        final String name = values.get(position).getTitle();
        holder.txtHeader.setText(name);

        //Makes rows of RecyclerView clickable, which upon clicking will display the details of the movie
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MovieDetailsFragment movieDetailsFragment = new MovieDetailsFragment();

                //Stores the details of the movie inside a bundle to use it in the MovieDetailsFragment
                Bundle movieDetailsBundle = new Bundle();
                movieDetailsBundle.putString(Constants.MOVIE_TITLE, values.get(position).getTitle());
                movieDetailsBundle.putString(Constants.MOVIE_RELEASE_DATE, values.get(position).getRelease_date());
                movieDetailsBundle.putString(Constants.MOVIE_PLOT, values.get(position).getOverview());
                movieDetailsBundle.putString(Constants.MOVIE_POSTER_URL, values.get(position).getPoster_path());
                movieDetailsBundle.putString(Constants.MOVIE_RATING, String.valueOf(values.get(position).getVoteAverage()));
                movieDetailsBundle.putString(Constants.MOVIE_LANGUAGE, values.get(position).getOriginal_language());


                movieDetailsFragment.setArguments(movieDetailsBundle);


                ((AppCompatActivity) holder.layout.getContext()).getSupportFragmentManager()
                        .beginTransaction().setCustomAnimations(R.anim.slide_in_right,R.anim.slide_out_left)
                        .replace(R.id.movieDetailsContainer, movieDetailsFragment).addToBackStack(null).commit();

            }
        });



    }

    @Override
    public int getItemCount() {

        return values.size();
    }

}
