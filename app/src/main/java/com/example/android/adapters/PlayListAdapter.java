package com.example.android.adapters;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.musicapp.R;
import com.example.android.musicapp.Tracks;

import java.util.ArrayList;

public class PlayListAdapter extends ArrayAdapter<Tracks> {

    public PlayListAdapter(Activity context, ArrayList<Tracks> Track) {
        super(context, 0, Track);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;

        if (listItemView == null) {

            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.playlist_view, parent, false);
        }


        return listItemView;
    }
}
