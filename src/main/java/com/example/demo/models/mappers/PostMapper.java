package com.example.demo.models.mappers;

import com.example.demo.models.Post;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

public class PostMapper implements RowMapper<Post> {

    @Override
    @Nullable
    public Post mapRow(@NonNull ResultSet rss, int rowNum) throws SQLException {
        Post post = new Post();
        post.setBackground(rss.getString("background"));
        post.setCreatedAt(rss.getString("createdAt"));
        post.setId(rss.getInt("id"));
        post.setIsPrivate(rss.getBoolean("isPrivate"));
        post.setMainContent(rss.getString("mainContent"));
        post.setTitle(rss.getString("title"));
        post.setUserID(rss.getString("userID"));
        return post;
    }
}
