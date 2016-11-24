package dragos.com.moviedbapp;

/**
 * Created by L on 11/23/2016.
 */

public class YouTubeConfig {

    private static final String DEVELOPER_KEY = "AIzaSyA-OhJbmHcm-I9MSZkuXPV6c4_F65g_tJI";
    private static String YOUTUBE_VIDEO_ID="QNpNwIJtpIs";

    public static String getDeveloperKey() {
        return DEVELOPER_KEY;
    }

    public static String getYoutubeVideoId() {
        return YOUTUBE_VIDEO_ID;
    }

    public static void setYoutubeVideoId(String youtubeVideoId) {
        YOUTUBE_VIDEO_ID = youtubeVideoId;
    }
}
