package com.example.android.musicapp;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.android.adapters.CategoryAdapter;
import com.example.android.adapters.TracksAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView bottomImage;
    LinearLayout albumView;
    private ArrayList<Tracks> tracks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
                return;
            }
        }

        ViewPager v = (ViewPager) findViewById(R.id.viewPager);

        CategoryAdapter adapter = new CategoryAdapter(this, getSupportFragmentManager());
        v.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(v);

        bottomImage = (ImageView) findViewById(R.id.current_play);
        albumView = (LinearLayout) findViewById(R.id.albumcards);
        tracks = new ArrayList<Tracks>();

        bottomImage.setOnClickListener(this);
    }


    public void onClick(View v) {
        if (v.getId() == R.id.current_play) {
            startActivity(new Intent(MainActivity.this, TrackView.class));
            finish();

        }
    }

    public void albumViewClick(View view) {
        startActivity(new Intent(MainActivity.this, AlbumView.class));
        finish();
    }

}


