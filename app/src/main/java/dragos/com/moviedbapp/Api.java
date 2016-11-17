package dragos.com.moviedbapp;

import dragos.com.moviedbapp.Model.MovieResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by L on 11/16/2016.
 */

public interface Api {
    String KEY = "api_key=6f5e2f0ce8d413514e08e0723adca6fb";

    @GET("discover/movie?"+KEY)
    Call<MovieResponse> getMovies(@Query("page") int page);


//    @GET("comments?site=stackoverflow")
//    Call<CommentsResponse> getComments(@Query("pagesize") int pagesize, @Query("min") int min, @Query("sort") String sort);
//
//
//    @GET("posts/{ids}?site=stackoverflow")
//    Call<PostResponse> getPosts(@Path("ids") long ids);
}
