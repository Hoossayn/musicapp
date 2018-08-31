package com.example.android.adapters;

import android.app.Activity;
import android.app.Fragment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.musicapp.R;
import com.example.android.musicapp.Tracks;

import java.util.ArrayList;

public class AlbumAdapter extends ArrayAdapter <Tracks> {
    public AlbumAdapter(Activity context, ArrayList<Tracks> Track) {
        super(context, 0, Track);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null ) {
            // inflating the layout used to view the album
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.album_view, parent, false);
        }

        Tracks currentTrack = getItem(position);

        TextView albumName = (TextView) convertView.findViewById(R.id.album_title);
        albumName.setText(currentTrack.getMalbumName());

        TextView artistName = (TextView) convertView.findViewById(R.id.album_artist);
        artistName.setText(currentTrack.getMartistName());

        //find the image in the list_item.xml layout with the ID image
        ImageView imageView = (ImageView) convertView.findViewById(R.id.albumPhoto);

        if (currentTrack.hasImage()) {
            imageView.setImageResource(currentTrack.getmImageResource());
            //make sure the view is reusable
            imageView.setVisibility(View.VISIBLE);
        } else {
            imageView.setImageResource(R.drawable.music_library);
            imageView.setVisibility(View.VISIBLE);

        }
        return convertView;
    }


}










