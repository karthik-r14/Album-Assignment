package com.karthikr.album_assignment.service;

import com.karthikr.album_assignment.model.Album;

import java.util.ArrayList;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface AlbumDataService {

    @GET("/albums")
    Observable<ArrayList<Album>> getAlbumsWithRx();
}
