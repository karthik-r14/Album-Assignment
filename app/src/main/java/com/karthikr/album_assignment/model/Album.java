package com.karthikr.album_assignment.model;

public class Album {
    private Integer userId;
    private Integer id;
    private String title;

    public Album(Integer userId, Integer id, String title) {
        this.userId = userId;
        this.id = id;
        this.title = title;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
