package dragos.com.moviedbapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import dragos.com.moviedbapp.Adapters.MovieAdapter;
import dragos.com.moviedbapp.Model.Movie;
import dragos.com.moviedbapp.Model.MovieResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
        GridView gridView;
        ArrayList<Movie> movies = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = (GridView) findViewById(R.id.movie_list);
        init();
        linkUi();
    }

     void linkUi() {



     }


    void init(){
//      getDataInList();

        RestClient.getApi().getMovies(1).enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                Log.d("Response", "Success");
                movies = (response.body().getMovies());
                movies.get(0).getTitle();
                movies.get(0).getId();
                movies.get(0).getPoster_path();
                movies.get(0).getOverview();
                movies.get(0).getVote_average();

                MovieAdapter movieAdapter = new MovieAdapter(MainActivity.this, movies);
                gridView.setAdapter(movieAdapter);
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {

            }
        });



    }

    private void getDataInList() {
        for (int i = 0; i <76; i++) {
            // Create a new object for each list item
            Movie movie = new Movie();
            movie.setTitle("title"+i);
            movie.setId(i);
            // Add this object into the ArrayList myList
            movies.add(movie);
        }


}
    }