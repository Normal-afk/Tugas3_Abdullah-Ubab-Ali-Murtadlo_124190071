package com.example.tugas3_intentrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private int RvOrien = 0;
    private Button btnGrid;
    private Button btnHorizontal;
    private Button btnVertical;
    private RecyclerView rvMovie;
    private ArrayList<MovieModel> listMovie = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvMovie = findViewById(R.id.rv_movie_list);
        rvMovie.setHasFixedSize(true);
        listMovie.addAll(MovieData.getListData());

        btnGrid = findViewById(R.id.btngrid);
        btnHorizontal = findViewById(R.id.btnhorizontal);
        btnVertical = findViewById(R.id.btnvertical);

        btnVertical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setRvOrien(0);
                showRecyclerList();
            }
        });
        btnHorizontal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setRvOrien(1);
                showRecyclerList();
            }
        });
        btnGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setRvOrien(2);
                showRecyclerList();
            }
        });

        showRecyclerList();
    }

    private void showRecyclerList(){
        switch (getRvOrien()){
            case 0 : rvMovie.setLayoutManager(new LinearLayoutManager( this, LinearLayoutManager.VERTICAL, false));
            break;
            case 1 : rvMovie.setLayoutManager(new LinearLayoutManager( this, LinearLayoutManager.HORIZONTAL, false));
            break;
            case 2 : rvMovie.setLayoutManager(new GridLayoutManager( this, 2));
            break;
            default : rvMovie.setLayoutManager(new LinearLayoutManager( this, LinearLayoutManager.VERTICAL, false));
        }
        MovieAdapter movieAdapter = new MovieAdapter(this);
        movieAdapter.setRvOrienta(getRvOrien());
        movieAdapter.setMovieModels(listMovie);
        rvMovie.setAdapter(movieAdapter);

        movieAdapter.setOnItemClickListener(new MovieAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(MainActivity.this, SinopsisMovie.class);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });
    }

    public int getRvOrien() {
        return RvOrien;
    }

    public void setRvOrien(int rvOrien) {
        RvOrien = rvOrien;
    }
}