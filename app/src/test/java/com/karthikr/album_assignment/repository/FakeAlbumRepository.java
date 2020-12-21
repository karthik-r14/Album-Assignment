package com.karthikr.album_assignment.repository;

import androidx.lifecycle.MutableLiveData;

import com.karthikr.album_assignment.model.Album;
import com.karthikr.album_assignment.model.AlbumRepository;

import java.util.ArrayList;

public class FakeAlbumRepository extends AlbumRepository {
    private MutableLiveData<ArrayList<Album>> fakeAlbumsLiveData = new MutableLiveData<>();

    @Override
    public MutableLiveData<ArrayList<Album>> getAlbumsLiveData() {
        ArrayList<Album> fakeAlbums = new ArrayList<>();
        fakeAlbums.add(new Album(1, 1, "Album1"));
        fakeAlbums.add(new Album(1, 2, "Album2"));

        fakeAlbumsLiveData.postValue(fakeAlbums);

        return fakeAlbumsLiveData;
    }
}
