package com.example.demo.DTOs;

public class UtilDTOs {

    public record Success(boolean success) {}

    public record ReviewWasMade(Long postID, UserOfAReview user, String comment, String createdAt) {
    }

    public record UserOfAReview(String avatar, String fullName) {
    }
}
