package com.example.tugas3_intentrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SinopsisMovie extends AppCompatActivity {

    private TextView tvJudul;
    private ImageView ivPoster;
    private TextView tvSinopsis;
    private MovieData movieData;

    private static String[] synopsis = new String[]{"A man ends world hunger with his rock collection.",
            "Dude invites some kids to a factory, 4 of them possibly die, then he tries to rip off the 5th one before letting him use the elevator.",
            "Depressed, widowed father teams up with mentally challenged woman to find his disabled son.",
            "Noseless guy has an unhealthy obsession with teenage boy.",
            "Group spending 9 hours returning jewelry.",
            "Man’s wife dies. He tries to get high in order to cope. Accidentally gets a minor high along with himself. They go on a major trip and end up good friends when they come down."
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sinopsis_movie);

        ivPoster = findViewById(R.id.ivposter_sinop_movie);
        tvJudul = findViewById(R.id.tvjudul_sinop_Movie);
        tvSinopsis = findViewById(R.id.tvsinopsis_movie);

        int j = getIntent().getIntExtra("position",0);

        movieData = new MovieData();

        ivPoster.setImageResource(movieData.getThumbnail(j));
        tvJudul.setText(movieData.getTitle(j));
        tvSinopsis.setText(synopsis[j]);

    }
}