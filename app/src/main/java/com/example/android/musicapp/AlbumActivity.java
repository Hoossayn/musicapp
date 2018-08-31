package com.example.android.musicapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.example.android.Ui.AlbumFragment;

public class AlbumActivity extends AppCompatActivity{


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.album_view);
        getSupportFragmentManager().beginTransaction().replace(R.id.albumcards, new AlbumFragment()).commit();


    }
}
