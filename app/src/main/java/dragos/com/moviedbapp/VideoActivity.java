package dragos.com.moviedbapp;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        videoView = (VideoView) findViewById(R.id.video);
        String videoUrl = "https://youtu.be/QNpNwIJtpIs";
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        mediaController.setMediaPlayer(videoView);

        Uri video = Uri.parse(videoUrl);
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(video);
        videoView.start();

    }
}
