package com.karthikr.album_assignment.view;

import android.content.Context;
import android.graphics.Movie;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.karthikr.album_assignment.R;
import com.karthikr.album_assignment.adapter.AlbumAdapter;
import com.karthikr.album_assignment.databinding.ActivityMainBinding;
import com.karthikr.album_assignment.model.Album;
import com.karthikr.album_assignment.viewmodel.AlbumViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private AlbumViewModel albumViewModel;
    private ActivityMainBinding binding;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        albumViewModel = ViewModelProviders.of(this).get(AlbumViewModel.class);

        init();
        observeAlbums();
    }

    private void init() {
        albumViewModel.getAllAlbums();
    }

    public void observeAlbums() {
        albumViewModel.getAllAlbums().observe(this, new Observer<ArrayList<Album>>() {
            @Override
            public void onChanged(ArrayList<Album> albums) {
                binding.albumList.setAdapter(new AlbumAdapter(albums));
                binding.albumList.setLayoutManager(new LinearLayoutManager(context));
            }
        });
    }
}