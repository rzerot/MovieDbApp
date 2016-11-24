package dragos.com.moviedbapp.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by L on 11/21/2016.
 */

public class Poster implements Serializable{
    @SerializedName("file_path")
    private String poster_path;

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }
}
