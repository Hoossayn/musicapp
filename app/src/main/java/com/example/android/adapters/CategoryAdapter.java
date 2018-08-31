package com.example.android.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.android.musicapp.R;
import com.example.android.Ui.AlbumFragment;
import com.example.android.Ui.ArtistFragment;
import com.example.android.Ui.PlaylistFragment;
import com.example.android.Ui.TracksFragment;

public class CategoryAdapter extends FragmentPagerAdapter {

    private Context mContext;
    public CategoryAdapter(Context context, FragmentManager fm){
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0){
            return new PlaylistFragment();

        }else if (position == 1){
            return new AlbumFragment();

        }else if (position == 2){
            return new TracksFragment();

        }else {
            return new ArtistFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        if (position == 0) {
            return mContext.getString(R.string.playList);
        }else if (position == 1){
            return  mContext.getString(R.string.album_name);
        }else if(position == 2) {
            return mContext.getString(R.string.track_name);
        }else{
            return mContext.getString(R.string.artist_name);
        }
    }
}
