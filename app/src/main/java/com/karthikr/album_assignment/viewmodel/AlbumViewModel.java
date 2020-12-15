package com.karthikr.album_assignment.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.karthikr.album_assignment.model.Album;
import com.karthikr.album_assignment.model.AlbumRepository;

import java.util.ArrayList;

public class AlbumViewModel extends AndroidViewModel {

    private AlbumRepository albumRepository;

    public AlbumViewModel(@NonNull Application application) {
        super(application);
        albumRepository = new AlbumRepository(application);
    }

    public LiveData<ArrayList<Album>> getAllAlbums() {
        return albumRepository.getAlbumsLiveData();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}