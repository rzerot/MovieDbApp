package dragos.com.moviedbapp.Model;

import java.io.Serializable;

/**
 * Created by L on 11/20/2016.
 */

public class Credit implements Serializable{
    private String name;
    private String profile_path;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfile_path() {
        return profile_path;
    }

    public void setProfile_path(String profile_path) {
        this.profile_path = profile_path;
    }
}
