package dragos.com.moviedbapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Objects;

import dragos.com.moviedbapp.Model.Movie;
import dragos.com.moviedbapp.MoreInfoActivity;
import dragos.com.moviedbapp.R;

/**
 * Created by L on 11/16/2016.
 */

public class MovieAdapter extends BaseAdapter {
    Context context;
    ArrayList<Movie> movies;
    LayoutInflater inflater;
    private static final String POSTER_LINK = "http://image.tmdb.org/t/p/w185_and_h278_bestv2";
    public static final String MOVIEKEY ="332";
    public MovieAdapter(Context context, ArrayList<Movie> movies) {
        this.context = context;
        this.movies = movies;
        inflater = LayoutInflater.from(this.context);
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int i) {
        return movies.get(i);
    }

    @Override
    public long getItemId(int i) {
        return movies.get(i).getId();
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        MyViewHolder myViewHolder;
        if (view == null) {

            view = inflater.inflate(R.layout.movie_list, viewGroup, false);
            myViewHolder = new MyViewHolder(view);
            view.setTag(myViewHolder);
        } else {
            myViewHolder = (MyViewHolder) view.getTag();
        }

        myViewHolder.title.setText(movies.get(i).getTitle());
//        myViewHolder.id.setText(""+movies.get(i).getId());
        myViewHolder.overview.setText(movies.get(i).getOverview());
        myViewHolder.moreInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MoreInfoActivity.class);
                intent.putExtra(MOVIEKEY,movies.get(i));
                context.startActivity(intent);

            }
        });
        Picasso.with(context).load(POSTER_LINK + movies.get(i).getPoster_path()).into(myViewHolder.poster_path);

        myViewHolder.vote_average.setText("" + movies.get(i).getVote_average());

        return view;
    }




    private class MyViewHolder {
        TextView title, id, overview, vote_average,moreInfo;
        ImageView poster_path;


        public MyViewHolder(View movie) {
            title = (TextView) movie.findViewById(R.id.title);
//            id = (TextView) movie.findViewById(R.id.movie_id);
            overview = (TextView) movie.findViewById(R.id.overview);
            poster_path = (ImageView) movie.findViewById(R.id.poster);
            vote_average = (TextView) movie.findViewById(R.id.vote_average);
            moreInfo = (TextView) movie.findViewById(R.id.more_info);
        }
    }
}
