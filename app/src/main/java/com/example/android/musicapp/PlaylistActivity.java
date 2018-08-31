package com.example.android.musicapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.android.Ui.PlaylistFragment;

public class PlaylistActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playlist_view);
        getSupportFragmentManager().beginTransaction().replace(R.id.playListView, new PlaylistFragment()).commit();
    }
}
