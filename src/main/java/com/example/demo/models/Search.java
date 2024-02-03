package com.example.demo.models;

public class Search {

    private int id;
    private int postID;
    private String createdAt;

    public Search() {}

    public Search(int id, int postID, String createdAt) {
        this.id = id;
        this.postID = postID;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Search [id=" + id + ", postID=" + postID + ", createdAt=" + createdAt + "]";
    }
}
