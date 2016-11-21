package dragos.com.moviedbapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class PosterActivity extends AppCompatActivity {
    long movieID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poster);
        Intent intent = getIntent();


        if (intent.hasExtra(MoreInfoActivity.POSTER_KEY)) {
            movieID = (long) intent.getExtras().get(MoreInfoActivity.POSTER_KEY);
            Log.d("zakey", "" + movieID);

        }
    }
}
