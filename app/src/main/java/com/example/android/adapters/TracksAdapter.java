package com.example.android.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.android.musicapp.MainActivity;
import com.example.android.musicapp.R;
import com.example.android.musicapp.Tracks;
import com.example.android.musicapp.TracksActivity;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class TracksAdapter extends BaseAdapter {

    private ArrayList<Tracks> songs;
    private LayoutInflater inflater;
    Context context;

    public TracksAdapter(Context c, ArrayList<Tracks> songs) {
        this.context = c;
        this.songs = songs;
        inflater = LayoutInflater.from(this.context);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {

            convertView = inflater.inflate(R.layout.tracks_view, parent, false);
        }

        TextView albumName = (TextView) convertView.findViewById(R.id.artist_track);
        TextView artistName = (TextView) convertView.findViewById(R.id.title_track);

        Tracks currentTrack = songs.get(position);

        albumName.setText(currentTrack.getmTitle());
        artistName.setText(currentTrack.getMartistName());


        convertView.setTag(position);

        return convertView;
    }

    @Override
    public int getCount() {
        return songs.size();
    }

    @Override
    public Object getItem(int position) {
        return songs;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

}
