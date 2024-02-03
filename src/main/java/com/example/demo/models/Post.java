package com.example.demo.models;

public class Post {

    private int id;
    private String title;
    private String createdAt;
    private String background;
    private String userID;
    private String mainContent;
    private boolean isPrivate;
    private String categoryID;

    public Post() {}

    public Post(
        int id,
        String title,
        String createdAt,
        String background,
        String userID,
        String mainContent,
        boolean isPrivate,
        String categoryID
    ) {
        this.id = id;
        this.title = title;
        this.createdAt = createdAt;
        this.background = background;
        this.userID = userID;
        this.mainContent = mainContent;
        this.isPrivate = isPrivate;
        this.categoryID = categoryID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getMainContent() {
        return mainContent;
    }

    public void setMainContent(String mainContent) {
        this.mainContent = mainContent;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }
}
