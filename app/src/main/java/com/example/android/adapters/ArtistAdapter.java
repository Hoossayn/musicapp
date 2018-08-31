package com.example.android.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.android.musicapp.R;
import com.example.android.musicapp.Tracks;

import java.util.ArrayList;

public class ArtistAdapter extends android.widget.BaseAdapter {

    private ArrayList<Tracks> artist;
    private LayoutInflater inflater;
    Context context;

    public ArtistAdapter(Context c, ArrayList<Tracks> songs){
        this.context = c;
        this.artist = songs;
        inflater = LayoutInflater.from(this.context);

    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {



        if(convertView == null) {

            convertView = inflater.inflate(R.layout.artist_list_view, parent, false);
        }

        TextView artistName = (TextView)convertView.findViewById(R.id.titleView);
        TextView albumName = (TextView)convertView.findViewById(R.id.artistView);


        Tracks currentTrack = artist.get(position);

        artistName.setText(currentTrack.getmTitle());
        albumName.setText(currentTrack.getMartistName());


        convertView.setTag(position);

        return convertView;
    }
    @Override
    public int getCount() {
        return artist.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
}
