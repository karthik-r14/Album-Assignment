package com.karthikr.album_assignment.model;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.karthikr.album_assignment.service.AlbumDataService;
import com.karthikr.album_assignment.service.RetrofitInstance;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class AlbumRepository {
    private MutableLiveData<ArrayList<Album>> albumsLiveData = new MutableLiveData<>();
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private Observable<ArrayList<Album>> albumResponseObservable;
    private ArrayList<Album> allAlbums;

    public AlbumRepository() {
    }

    public MutableLiveData<ArrayList<Album>> getAlbumsLiveData() {
        allAlbums = new ArrayList<>();
        AlbumDataService albumService = RetrofitInstance.getService();
        albumResponseObservable = albumService.getAlbumsWithRx();

        Log.i("Album observable :", albumResponseObservable.toString());

        compositeDisposable.add(albumResponseObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<ArrayList<Album>>() {
                    @Override
                    public void onNext(ArrayList<Album> albums) {
                        allAlbums = albums;
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("Album Error :", e.toString());
                    }

                    @Override
                    public void onComplete() {
                        albumsLiveData.postValue(allAlbums);
                    }
                }));

        return albumsLiveData;
    }

    public void clear() {
        compositeDisposable.clear();
    }
}