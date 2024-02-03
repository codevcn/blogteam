package com.example.demo.models;

public class Interaction {

    private int postID;
    private String userID;
    private boolean likeDislike;
    private String createdAt;

    public Interaction() {}

    public Interaction(int postID, String userID, boolean likeDislike, String createdAt) {
        this.postID = postID;
        this.userID = userID;
        this.likeDislike = likeDislike;
        this.createdAt = createdAt;
    }

    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public boolean isLikeDislike() {
        return likeDislike;
    }

    public void setLikeDislike(boolean likeDislike) {
        this.likeDislike = likeDislike;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return (
            "Interaction [postID=" +
            postID +
            ", userID=" +
            userID +
            ", likeDislike=" +
            likeDislike +
            ", createdAt=" +
            createdAt +
            "]"
        );
    }
}
