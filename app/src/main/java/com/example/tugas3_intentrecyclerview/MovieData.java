package com.example.tugas3_intentrecyclerview;

import java.util.ArrayList;

public class MovieData {

    private static String[] title = new String[]{"Avengers : Infinity War", "Charlie and The Chocolate Factory",
                                    "Finding Nemo", "Harry Potter", "The Lord of The Rings", "UP"};
    private static int[] thumbnail = new int[]{R.drawable.infinity_war, R.drawable.charlie, R.drawable.nemo,
                                     R.drawable.heri_potter, R.drawable.loring, R.drawable.up};

    public static ArrayList<MovieModel> getListData(){
        MovieModel movieModel = null;
        ArrayList<MovieModel> list = new ArrayList<>();

        for (int i = 0; i < title.length; i++){
            movieModel = new MovieModel();
            movieModel.setPosterMovie(thumbnail[i]);
            movieModel.setJudulMovie(title[i]);
            list.add(movieModel);
        }
        return list;
    }

    public String getTitle(int position) {
        return title[position];
    }

    public int getThumbnail(int position) {
        return thumbnail[position];
    }
}
