package dragos.com.moviedbapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import dragos.com.moviedbapp.Adapters.CastAdapter;
import dragos.com.moviedbapp.Adapters.MovieAdapter;
import dragos.com.moviedbapp.Model.Credit;
import dragos.com.moviedbapp.Model.CreditResponse;
import dragos.com.moviedbapp.Model.Movie;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoreInfoActivity extends FragmentActivity {
    final static String POSTER_KEY = "123";
    final static String VIDEO_KEY = "333";
    CastAdapter castAdapter;
    ViewPager viewPager;
    ImageButton picture_tab;
    ArrayList<Credit> credits;
    ImageButton video_btn;

    Movie movie;
    ImageView info_image;
    TextView more_info_title, more_info_overview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_info);
        Intent intent = getIntent();

        if (intent.hasExtra(MovieAdapter.MOVIEKEY)) {
            movie = (Movie) intent.getExtras().get(MovieAdapter.MOVIEKEY);
        }
        if (movie != null) {
            init();
            Log.d("movie", "" + movie.getId());
            Picasso.with(MoreInfoActivity.this).load(MovieAdapter.POSTER_LINK + movie.getPoster_path()).into(info_image);
            //http://stackoverflow.com/questions/30664254/using-picasso-library-with-a-circle-image-view

            more_info_title.setText(movie.getTitle());
            more_info_overview.setText(movie.getOverview());

            setUI();
            setListeners();

        }
    }

    void setListeners() {
        picture_tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MoreInfoActivity.this, PosterActivity.class);
                intent.putExtra(POSTER_KEY, movie);
                startActivity(intent);

            }
        });
        video_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MoreInfoActivity.this, VideoActivity.class);
                intent.putExtra(VIDEO_KEY, movie);
                startActivity(intent);
            }
        });

    }


    void init() {
        info_image = (ImageView) findViewById(R.id.info_image);
        more_info_title = (TextView) findViewById(R.id.more_info_title);
        more_info_overview = (TextView) findViewById(R.id.more_info_overview);

        RestClient.getApi().getCredits(movie.getId()).enqueue(new Callback<CreditResponse>() {
            @Override
            public void onResponse(Call<CreditResponse> call, Response<CreditResponse> response) {
                credits = (response.body().getCredits());
                viewPager = (ViewPager) findViewById(R.id.vpPager);
                castAdapter = new CastAdapter(MoreInfoActivity.this, credits);
                viewPager.setAdapter(castAdapter);
                viewPager.setOffscreenPageLimit(castAdapter.getCount());
            }

            @Override
            public void onFailure(Call<CreditResponse> call, Throwable t) {

            }
        });

    }


    void setUI() {
        picture_tab = (ImageButton) findViewById(R.id.picture);
        video_btn = (ImageButton) findViewById(R.id.videos);
    }


}
