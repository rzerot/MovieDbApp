package dragos.com.moviedbapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

import dragos.com.moviedbapp.Model.Video;

/**
 * Created by L on 11/24/2016.
 */

public class VideoAdapter extends BaseAdapter {
    Context context;
    ArrayList<Video> videos;
    LayoutInflater inflater;

    public VideoAdapter(Context context, ArrayList<Video> videos) {
        this.context = context;
        this.videos = videos;
    }


    @Override
    public int getCount() {
        return videos.size();
    }

    @Override
    public Object getItem(int i) {
        return videos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return null;
    }
}
