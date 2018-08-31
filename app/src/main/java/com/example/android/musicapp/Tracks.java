package com.example.android.musicapp;

public class Tracks {
    private String malbumName;
    private String martistName;
    private String mtracktTime;
    private String mtrackName;
    private String mTitle;
    private String mNoOfTracks;
    private String mNoOfTrack;
    private long mId;
    private int mImageResource = NO_IMAGE_STATE;;
    private static final int NO_IMAGE_STATE = -1;


    public Tracks(String albumName, String trackName, String artistName, String trackTime, int imageResourceId){
        malbumName =  albumName;
        martistName = artistName;
        mtrackName = trackName;
        mtracktTime = trackTime;
        mImageResource = imageResourceId;
    }

    public Tracks(String albumName, String artistName, long id){
        malbumName = albumName;
        martistName = artistName;
        mId = id;
    }

    public Tracks(long id, String title, String album, int art){
        mId = id;
        mTitle = title;
        malbumName = album;
        mImageResource = art;
    }

    public Tracks( long id, String titile , String noOfTracks){
        mId = id;
        mTitle = titile;
        mNoOfTracks = noOfTracks;

        }

    public Tracks( long id, String artist ){
        mId = id;
        martistName = artist;

    }


    // gets the albumName
    public String getMalbumName(){
        return malbumName;
    }
    // gets the artistName
    public String getMartistName(){
        return martistName;
    }
    //get the title of the tracks
    public String getmTitle(){return mTitle;}
    //gets the id of the tracks
    public long getmId(){return mId;}
    //gets the image if the tracks
    public int getmImageResource(){
        return mImageResource;
    }

    public boolean hasImage(){
        return   mImageResource != NO_IMAGE_STATE;
    }

}
