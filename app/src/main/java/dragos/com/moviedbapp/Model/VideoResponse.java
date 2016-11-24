package dragos.com.moviedbapp.Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by java2 on 11/21/2016.
 */

public class VideoResponse implements Serializable {

    private ArrayList<Video> videos;

    public ArrayList<Video> getVideos() {
        return videos;
    }

    public void setVideos(ArrayList<Video> videos) {
        this.videos = videos;
    }
}
