package dragos.com.moviedbapp;

import java.security.Key;

import dragos.com.moviedbapp.Model.Credit;
import dragos.com.moviedbapp.Model.CreditResponse;
import dragos.com.moviedbapp.Model.MovieResponse;
import dragos.com.moviedbapp.Model.PosterResponse;
import dragos.com.moviedbapp.Model.VideoResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by L on 11/16/2016.
 */

public interface Api {
    String KEY = "api_key=6f5e2f0ce8d413514e08e0723adca6fb";

    @GET("discover/movie?" + KEY)
    Call<MovieResponse> getMovies(@Query("page") int page);

    @GET("movie/{movie_id}/credits?" + KEY)
    Call<CreditResponse> getCredits(@Path("movie_id") long movie_id);

    @GET("movie/{movie_id}/images?" + KEY)
    Call<PosterResponse> getPosters(@Path("movie_id") long movie_id);
//    https://api.themoviedb.org/3/movie/284052/credits?api_key=6f5e2f0ce8d413514e08e0723adca6fb

    @GET("movie/{movie_id}/videos?" + KEY)
    Call<VideoResponse> getVideos(@Path("movie_id") long movie_id);


}
