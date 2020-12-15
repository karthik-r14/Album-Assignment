package com.karthikr.album_assignment.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.karthikr.album_assignment.R;
import com.karthikr.album_assignment.model.Album;

import java.util.ArrayList;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder> {

    private ArrayList<Album> albums;

    public AlbumAdapter(ArrayList<Album> albums) {
        this.albums = albums;
    }

    @NonNull
    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.album_list_item, parent, false);
        return new AlbumViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumViewHolder holder, int position) {

        holder.albumTitle.setText(albums.get(position).getTitle());
        holder.albumId.setText(albums.get(position).getId().toString());
        holder.userId.setText(albums.get(position).getUserId().toString());
    }

    @Override
    public int getItemCount() {
        return albums.size();
    }


    public class AlbumViewHolder extends RecyclerView.ViewHolder {

        public TextView albumTitle;
        public TextView albumId;
        public TextView userId;

        public AlbumViewHolder(View itemView) {
            super(itemView);

            albumTitle = itemView.findViewById(R.id.album_title);
            albumId = itemView.findViewById(R.id.album_id);
            userId = itemView.findViewById(R.id.user_id);
        }
    }
}
