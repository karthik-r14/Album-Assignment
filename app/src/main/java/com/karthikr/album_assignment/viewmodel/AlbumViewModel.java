package com.karthikr.album_assignment.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.karthikr.album_assignment.model.Album;
import com.karthikr.album_assignment.model.AlbumRepository;

import java.util.ArrayList;

public class AlbumViewModel extends ViewModel {

    private AlbumRepository albumRepository;

    public AlbumViewModel(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    public LiveData<ArrayList<Album>> getAllAlbums() {
        return albumRepository.getAlbumsLiveData();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        albumRepository.clear();
    }
}