package com.example.flixsterapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.flixsterapplication.Models.Movie;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import org.parceler.Parcels;

public class DetailActivity extends YouTubeBaseActivity {


    private static final String API_KEY = "AIzaSyAdaDxpYDgg7F7ojtIu68LGuZrWA_DmtWI";
    TextView textTitle;
    TextView textOverview;
    RatingBar ratingBar;
    YouTubePlayerView youTubePlayerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        textTitle = findViewById(R.id.textTitle);
        textOverview = findViewById(R.id.textOverview);
        ratingBar = findViewById(R.id.ratingBar);
        youTubePlayerView = findViewById(R.id.player);

       Movie movie = Parcels.unwrap(getIntent().getParcelableExtra("movie"));
       textTitle.setText(movie.getTitle());
       textOverview.setText(movie.getOverview());
       ratingBar.setRating((float)movie.getRating());

       youTubePlayerView.initialize(API_KEY, new YouTubePlayer.OnInitializedListener() {
           @Override
           public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
               Log.d("DetailActivity", "onYouTubeSuccess");
               youTubePlayer.cueVideo("5xVh-7ywKpE");
           }

           @Override
           public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
               Log.d("DetailActivity", "onYoutubeFailure");
           }
       });
    }
}