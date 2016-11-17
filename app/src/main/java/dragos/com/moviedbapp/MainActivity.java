package dragos.com.moviedbapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import dragos.com.moviedbapp.Adapters.MovieAdapter;
import dragos.com.moviedbapp.Model.Movie;
import dragos.com.moviedbapp.Model.MovieResponse;
import dragos.com.moviedbapp.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    ArrayList<Movie> movies = new ArrayList<>();
    private int page = 1;
    private MovieAdapter movieAdapter;
    TextView moreInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = (GridView) findViewById(R.id.movie_list);

        init();
        linkUi();
        setListner();
    }

    void setListner() {


        gridView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {
                Log.d("ScrollStateChanged", "" + i);
            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {
                Log.d("onScroll", "" + i);
                if (i + i1 > i2 - 4 && i2 != 0) {

                    RestClient.getApi().getMovies(page++).enqueue(new Callback<MovieResponse>() {
                        ArrayList<Movie> nextMovies;

                        @Override
                        public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                            Log.d("Response", "Success");
                            nextMovies = (response.body().getMovies());
                            movies.addAll(nextMovies);


                            movieAdapter.notifyDataSetChanged();
                        }

                        @Override
                        public void onFailure(Call<MovieResponse> call, Throwable t) {

                        }
                    });


                }

            }
        });


    }

    void linkUi() {


    }


    void init() {


        RestClient.getApi().getMovies(page).enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                Log.d("Response", "Success");
                movies = (response.body().getMovies());
                movieAdapter = new MovieAdapter(MainActivity.this, movies);
                gridView.setAdapter(movieAdapter);
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
            }
        });


    }

    private void getDataInList() {
        for (int i = 0; i < 76; i++) {
            // Create a new object for each list item
            Movie movie = new Movie();
            movie.setTitle("title" + i);
            movie.setId(i);
            // Add this object into the ArrayList myList
            movies.add(movie);
        }


    }
}