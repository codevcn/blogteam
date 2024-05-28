package com.example.demo.DTOs;
import com.example.demo.models.User;
public class UtilDTOs {

    public record Success(boolean success) {}

    public record SearchPost(Long id, String title, String createdAt, String background, User user, String mainContent,
        Boolean isPrivate, String hashtag, Boolean deleted, String updateAt) {
    }
}
