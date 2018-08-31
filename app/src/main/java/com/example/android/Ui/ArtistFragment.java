package com.example.android.Ui;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.android.adapters.ArtistAdapter;
import com.example.android.adapters.TracksAdapter;
import com.example.android.musicapp.R;
import com.example.android.musicapp.Tracks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ArtistFragment extends Fragment {

    private ArrayList<Tracks> artistView;
    private ListView songView;


    public ArtistFragment(){ }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.artist_list, container, false);

        songView =  (ListView)rootView.findViewById(R.id.artistListView);
        artistView = new ArrayList<Tracks>();


        searchMusic();

        // sort the usic alphabetically i think
        Collections.sort(artistView, new Comparator<Tracks>() {
            public int compare(Tracks a, Tracks b){
                return a.getmTitle().compareTo(b.getmTitle());
            }
        });

        ArtistAdapter artistAdapter = new ArtistAdapter(getActivity(),artistView);
        songView.setAdapter(artistAdapter);

        return rootView;

    }
    public void searchMusic(){
        ContentResolver resolverCompat = getActivity().getContentResolver();
        Uri songUri = android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        Cursor databaseCusor = resolverCompat.query(songUri, null, null, null, null);
        if(databaseCusor != null && databaseCusor.moveToFirst()){

            //get the selected song properties to fetch
            int id = databaseCusor.getColumnIndex(MediaStore.Audio.Media._ID);
            int title = databaseCusor.getColumnIndex(MediaStore.Audio.Artists.ARTIST);
            int artist = databaseCusor.getColumnIndex(MediaStore.Audio.Albums.ARTIST);


            do {
                //fetch propertied from each song
                long currentId  = databaseCusor.getLong(id);
                String currentTitle = databaseCusor.getString(title);
                String currentArtist = databaseCusor.getString(artist);
                artistView.add(new Tracks(currentId,currentTitle,  currentArtist));


            }while (databaseCusor.moveToNext());
            databaseCusor.close();
        }
    }
}
