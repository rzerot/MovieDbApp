package dragos.com.moviedbapp.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import dragos.com.moviedbapp.R;

/**
 * Created by L on 11/19/2016.
 */

public class CastFragment extends Fragment {
    Context context;
    String link;
    ImageView actorPhoto;
    TextView actorName;
    public static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";

    public static CastFragment newInstance(String message) {
        CastFragment f = new CastFragment();

        Bundle bdl = new Bundle(2);

        bdl.putString(EXTRA_MESSAGE, message);
        bdl.putString(EXTRA_MESSAGE, message);
        f.setArguments(bdl);

        return f;
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle saveInstancestate) {
        String message = getArguments().getString(EXTRA_MESSAGE);
        View view = inflater.inflate(R.layout.cast_fragment, parent, false);
        actorName = (TextView) view.findViewById(R.id.actor_name);
        actorPhoto = (ImageView) view.findViewById(R.id.actor_photo);
        actorName.setText(message);
        return view;
    }
}
