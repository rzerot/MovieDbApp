package dragos.com.moviedbapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;

import dragos.com.moviedbapp.Model.Movie;
import dragos.com.moviedbapp.Model.Video;
import dragos.com.moviedbapp.Model.VideoResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VideoActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {
//    VideoView videoView;
    private static final int RECOVERY_DIALOG = 1;
    private YouTubePlayerView playerView;
    Movie movie;
    long video_id;
    String youtube_key;
    ArrayList<Video> videos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        Intent intent = getIntent();

        if (intent.hasExtra(MoreInfoActivity.VIDEO_KEY)) {
            movie = (Movie) intent.getExtras().get(MoreInfoActivity.VIDEO_KEY);
        }
        if (movie != null) {
            video_id = movie.getId();
            init();
        }
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);



//youtube
        playerView.initialize(YouTubeConfig.getDeveloperKey(), this);
        //end
//        String videoUrl = "https://youtu.be/QNpNwIJtpIs";
//        MediaController mediaController = new MediaController(this);
//        mediaController.setAnchorView(videoView);
//        mediaController.setMediaPlayer(videoView);
//
//        Uri video = Uri.parse(videoUrl);
//        videoView.setMediaController(mediaController);
//        videoView.setVideoURI(video);
//        videoView.start();

    }


    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        if (!b) {
//            youTubePlayer.loadVideo(youtube_key);
//            youTubePlayer.cueVideo(youtube_key);
//            youTubePlayer.setPlayerStyle(YouTubePlayer.PlayerStyle.CHROMELESS);
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        if (youTubeInitializationResult.isUserRecoverableError()) {
            youTubeInitializationResult.getErrorDialog(this, RECOVERY_DIALOG).show();
        } else {
            String errorMessage = "There was an error initializing the YouTubePlayer ";
            Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RECOVERY_DIALOG) {
            // Retry initialization if user performed a recovery action
            getYouTubePlayerProvider().initialize(YouTubeConfig.getYoutubeVideoId(), this);
        }
    }

    private YouTubePlayer.Provider getYouTubePlayerProvider() {
        return (YouTubePlayerView) findViewById(R.id.youtube_view);
    }
//youtube end
    private void init() {
        playerView = (YouTubePlayerView) findViewById(R.id.youtube_view);
        RestClient.getApi().getVideos(video_id).enqueue(new Callback<VideoResponse>() {
            @Override
            public void onResponse(Call<VideoResponse> call, Response<VideoResponse> response) {
                videos = response.body().getVideos();
                youtube_key = videos.get(0).getKey();
            }

            @Override
            public void onFailure(Call<VideoResponse> call, Throwable t) {

            }
        });
    }
}
