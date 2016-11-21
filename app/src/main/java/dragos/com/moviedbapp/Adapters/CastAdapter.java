package dragos.com.moviedbapp.Adapters;


import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import dragos.com.moviedbapp.Model.Credit;
import dragos.com.moviedbapp.R;
import dragos.com.moviedbapp.util.CircleImage;

/**
 * Created by L on 11/19/2016.
 */

public class CastAdapter extends PagerAdapter {
    public static final String ACTOR_IMAGE = "https://image.tmdb.org/t/p/w66_and_h66_bestv2/";

    ArrayList<Credit> credits;

    private Context context;
    LayoutInflater layoutInflater;

    public CastAdapter(Context context, ArrayList<Credit> credits) {
        this.context = context;
        this.credits = credits;

    }

    @Override
    public int getCount() {
        return credits.size();
    }

    public Object instantiateItem(ViewGroup container, int position) {
        ImageView actor_photo;
        TextView actor_name;
        ImageButton picture_tab;

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = layoutInflater.inflate(R.layout.cast_fragment, container, false);

        actor_photo = (ImageView) itemView.findViewById(R.id.actor_photo);

        actor_name = (TextView) itemView.findViewById(R.id.actor_name);
        actor_name.setText(credits.get(position).getName());


        Picasso.with(context).load(ACTOR_IMAGE + credits.get(position).getProfile_path()).transform(new CircleImage()).into(actor_photo);


        container.addView(itemView);


        return itemView;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }


}


