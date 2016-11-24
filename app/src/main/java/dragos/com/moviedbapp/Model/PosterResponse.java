package dragos.com.moviedbapp.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by L on 11/21/2016.
 */

public class PosterResponse implements Serializable{
@SerializedName("backdrops")
 private   ArrayList<Poster> posters = new ArrayList<>();


    public ArrayList<Poster> getPosters() {
        return posters;
    }

    public void setPosters(ArrayList<Poster> posters) {
        this.posters = posters;
    }
}
