package dragos.com.moviedbapp;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import java.util.ArrayList;

import dragos.com.moviedbapp.Adapters.PosterAdapter;
import dragos.com.moviedbapp.Model.Movie;
import dragos.com.moviedbapp.Model.Poster;
import dragos.com.moviedbapp.Model.PosterResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PosterActivity extends AppCompatActivity {
    Movie movie;
    ImageView poster;
    ArrayList<Poster> posters;
    ViewPager viewPager;
    PosterAdapter posterAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poster);
        Intent intent = getIntent();


        if (intent.hasExtra(MoreInfoActivity.POSTER_KEY)) {
            movie = (Movie) intent.getExtras().get(MoreInfoActivity.POSTER_KEY);
            Log.d("zakey", "" + movie.getId());

        }
        if (movie != null) {
            init();
            poster = (ImageView) findViewById(R.id.poster);

            RestClient.getApi().getPosters(movie.getId()).enqueue(new Callback<PosterResponse>() {
                @Override
                public void onResponse(Call<PosterResponse> call, Response<PosterResponse> response) {
                    posters = (response.body().getPosters());

                    viewPager = (ViewPager) findViewById(R.id.poster_pager);
                    posterAdapter = new PosterAdapter(PosterActivity.this,posters);
                    viewPager.setAdapter(posterAdapter);
                    viewPager.setOffscreenPageLimit(posterAdapter.getCount());
                }

                @Override
                public void onFailure(Call<PosterResponse> call, Throwable t) {

                }
            });
        }


    }

    public void init() {


    }
}
