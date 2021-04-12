package com.example.tugas3_intentrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    private  int RvOrienta;
    private Context context;
    private ArrayList<MovieModel> movieModels;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick (int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }

    public MovieAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<MovieModel> getMovieModels() {
        return movieModels;
    }

    public void setMovieModels(ArrayList<MovieModel> movieModels) {
        this.movieModels = movieModels;
    }

    public int getRvOrienta() {
        return RvOrienta;
    }

    public void setRvOrienta(int rvOrienta) {
        RvOrienta = rvOrienta;
    }

    @NonNull
    @Override
    public MovieAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow;
        switch (getRvOrienta()){
            case 0 : itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_recyclerview_vetical, viewGroup, false);
                break;
            case 1 : itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_recyclerview_grid, viewGroup, false);
                break;
            case 2: itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_recyclerview_grid, viewGroup, false);
                break;
            default : itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_recyclerview_grid, viewGroup, false);
        }
        return new ViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.ViewHolder viewHolder, int i) {
        Glide.with(context).load(getMovieModels().get(i).getPosterMovie()).into(viewHolder.ivPosterMovie);
        viewHolder.tvJudulMovie.setText(getMovieModels().get(i).getJudulMovie());
    }

    @Override
    public int getItemCount() {
        return getMovieModels().size();
    }

    public class ViewHolder  extends RecyclerView.ViewHolder{
        private ImageView ivPosterMovie;
        private TextView tvJudulMovie;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivPosterMovie = itemView.findViewById(R.id.poster_movie);
            tvJudulMovie = itemView.findViewById(R.id.judul_movie);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION){
                        mListener.onItemClick(position);
                    }
                }
            });
        }
    }
}
