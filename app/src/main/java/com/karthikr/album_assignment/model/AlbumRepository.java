package com.karthikr.album_assignment.model;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class AlbumRepository {
    private Application application;
    private MutableLiveData<ArrayList<Album>> albumsLiveData = new MutableLiveData<>();
    private ArrayList<Album> albums;

    public AlbumRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<ArrayList<Album>> getAlbumsLiveData() {
        albums = new ArrayList<>();

        albums.add(new Album(1, 1, "Album 1"));
        albums.add(new Album(2, 2, "Album 2"));

        albumsLiveData.postValue(albums);

        return albumsLiveData;
    }
}
