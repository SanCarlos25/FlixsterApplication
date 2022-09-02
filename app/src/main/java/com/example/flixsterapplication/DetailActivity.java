package com.example.flixsterapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.flixsterapplication.Models.Movie;

import org.parceler.Parcels;

public class DetailActivity extends AppCompatActivity {


    private static final String API_KEY = "AIzaSyAdaDxpYDgg7F7ojtIu68LGuZrWA_DmtWI";
    TextView textTitle;
    TextView textOverview;
    RatingBar ratingBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        textTitle = findViewById(R.id.textTitle);
        textOverview = findViewById(R.id.textOverview);
        ratingBar = findViewById(R.id.ratingBar);

       Movie movie = Parcels.unwrap(getIntent().getParcelableExtra("movie"));
       textTitle.setText(movie.getTitle());
       textOverview.setText(movie.getOverview());
       ratingBar.setRating((float)movie.getRating());


    }
}