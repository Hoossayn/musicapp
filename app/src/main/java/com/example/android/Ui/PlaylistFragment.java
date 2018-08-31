package com.example.android.Ui;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.support.v4.app.Fragment;

import com.example.android.adapters.PlayListAdapter;
import com.example.android.adapters.TracksAdapter;
import com.example.android.musicapp.R;
import com.example.android.musicapp.Tracks;

import java.util.ArrayList;

public class PlaylistFragment extends Fragment {

    public PlaylistFragment() {
        //requires empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.playlist_view, container, false);


        return rootView;
    }
}
