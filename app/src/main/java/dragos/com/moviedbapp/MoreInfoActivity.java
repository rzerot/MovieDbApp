package dragos.com.moviedbapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import dragos.com.moviedbapp.Adapters.MovieAdapter;
import dragos.com.moviedbapp.Model.Movie;

public class MoreInfoActivity extends AppCompatActivity {
    Movie movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_info);
        Intent intent = getIntent();
        if (intent.hasExtra(MovieAdapter.MOVIEKEY)) {
            movie = (Movie) intent.getExtras().get(MovieAdapter.MOVIEKEY);
        }
        if (movie != null) {

            Log.d("movie",""+ movie.getId());
            init();
            setUI();


        }
    }

    void setUI() {
    }

    void init() {
    }


}
