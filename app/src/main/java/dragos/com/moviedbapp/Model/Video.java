package dragos.com.moviedbapp.Model;

import java.io.Serializable;

/**
 * Created by java2 on 11/21/2016.
 */

public class Video implements Serializable{
    private String key;
    private String site;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }
}
