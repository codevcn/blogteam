package com.example.demo.models;

public class Review {

    private int postID;
    private String userID;
    private String comment;
    private String createdAt;

    public Review() {}

    public Review(int postID, String userID, String comment, String createdAt) {
        this.postID = postID;
        this.userID = userID;
        this.comment = comment;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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
            "Review [postID=" +
            postID +
            ", userID=" +
            userID +
            ", comment=" +
            comment +
            ", createdAt=" +
            createdAt +
            "]"
        );
    }
}
