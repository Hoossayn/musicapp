package com.example.android.Ui;

import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.android.adapters.AlbumAdapter;
import com.example.android.adapters.PlayListAdapter;
import com.example.android.adapters.TracksAdapter;
import com.example.android.musicapp.R;
import com.example.android.musicapp.Tracks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AlbumFragment extends Fragment {


    private GridView songView;
    private ArrayList<Tracks> songs;


    public AlbumFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.grid_view, container, false);

        songView = (GridView) rootView.findViewById(R.id.gridView);
        songs = new ArrayList<>();


        searchMusic();

        Collections.sort(songs, new Comparator<Tracks>() {
            public int compare(Tracks a, Tracks b) {
                return a.getmTitle().compareTo(b.getmTitle());
            }
        });

        AlbumAdapter albumAdapter = new AlbumAdapter(getActivity(), songs);
        songView.setAdapter(albumAdapter);

        return rootView;
    }

    public void searchMusic() {
        ContentResolver resolverCompat = getActivity().getContentResolver();
        Cursor databaseCusor = resolverCompat.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, new String[]{

                        MediaStore.Audio.Media._ID, MediaStore.Audio.Media.TITLE, MediaStore.Audio.Media.ARTIST,
                        MediaStore.Audio.Media.ALBUM},
                MediaStore.Audio.Media.IS_MUSIC + "=1", null, null
        );

        if (databaseCusor != null && databaseCusor.getCount() > 0 && databaseCusor.moveToFirst()) {
            int id = databaseCusor.getColumnIndex(MediaStore.Audio.Media._ID);
            int title = databaseCusor.getColumnIndex(MediaStore.Audio.Media.TITLE);
            int album = databaseCusor.getColumnIndex(MediaStore.Audio.Albums.ALBUM);
            //  int albumArt = databaseCusor.getColumnIndex(MediaStore.Audio.Albums.ALBUM_ART);


            do {
                long currentId = databaseCusor.getLong(id);
                String currentTitle = databaseCusor.getString(title);
                String currentArtist = databaseCusor.getString(album);
                //    int currentArt = databaseCusor.getInt(albumArt);
                songs.add(new Tracks(currentId, currentTitle, currentArtist));
/*
                 bm = BitmapFactory.decodeFile(currentArtist);
               // albumImage = (ImageView) getActivity().findViewById(R.id.albumPhoto);
                albumImage.setImageBitmap(bm);*/

            } while (databaseCusor.moveToNext());
            databaseCusor.close();

        }
    }
}