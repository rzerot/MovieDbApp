package dragos.com.moviedbapp.Adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import dragos.com.moviedbapp.Model.Poster;
import dragos.com.moviedbapp.R;
import dragos.com.moviedbapp.util.CircleImage;

/**
 * Created by L on 11/21/2016.
 */

public class PosterAdapter extends PagerAdapter {
    ArrayList<Poster> posters;
    public static final String POSTERS_PATH = "https://image.tmdb.org/t/p/original";

    Context context;
    LayoutInflater inflater;


    public PosterAdapter(Context context, ArrayList<Poster> posters) {
        this.context = context;
        this.posters = posters;
    }

    public Object instantiateItem(ViewGroup container, int position) {
        ImageView poster;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.poster_fragment, container, false);
        poster = (ImageView) itemView.findViewById(R.id.poster);
        Log.d("poster_path",POSTERS_PATH+posters.get(position).getPoster_path());
        Picasso.with(context).load(POSTERS_PATH + posters.get(position).getPoster_path()).into(poster);

        container.addView(itemView);
        return itemView;
    }

    @Override
    public int getCount() {
        return posters.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout)object);
    }
}
