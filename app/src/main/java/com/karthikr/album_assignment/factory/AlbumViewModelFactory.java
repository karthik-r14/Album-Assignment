package com.karthikr.album_assignment.factory;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.karthikr.album_assignment.model.AlbumRepository;
import com.karthikr.album_assignment.viewmodel.AlbumViewModel;

public class AlbumViewModelFactory implements ViewModelProvider.Factory {
    private AlbumRepository albumRepository;

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(AlbumViewModel.class)) {
            albumRepository = new AlbumRepository();
            return (T) new AlbumViewModel(albumRepository);
        } else {
            throw new IllegalArgumentException("Unknown class");
        }
    }
}