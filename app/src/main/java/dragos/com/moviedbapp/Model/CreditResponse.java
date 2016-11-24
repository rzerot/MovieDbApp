package dragos.com.moviedbapp.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by L on 11/20/2016.
 */

public class CreditResponse implements Serializable{
    @SerializedName("cast")
 private    ArrayList<Credit> credits;

    public ArrayList<Credit> getCredits() {
        return credits;
    }

    public void setCredits(ArrayList<Credit> credits) {
        this.credits = credits;
    }
}
