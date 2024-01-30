package com.example.demo.DAOs;

import com.example.demo.models.Post;
import com.example.demo.models.mappers.PostMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PostDAO {

    private final String tableName = "posts";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int count() {
        String sql = "SELECT COUNT(*) FROM " + tableName;
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count == null ? 0 : count;
    }

    public List<Post> findAll() {
        String sql = "SELECT * FROM " + tableName;
        return jdbcTemplate.query(sql, new PostMapper());
    }

    public int create(final Post post) {
        String sql =
            "INSERT INTO " +
            tableName +
            "(title, background, userID, mainContent, isPrivate)" +
            " VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(
            sql,
            post.getTitle(),
            post.getBackground(),
            post.getUserID(),
            post.getMainContent(),
            post.getIsPrivate() 
        );
    }

    public Post findById(final int post_id) {
        String sql = "SELECT * FROM " + tableName + " WHERE id = ?";
        Post post = jdbcTemplate.queryForObject(sql, new PostMapper(), post_id);
        return post;
    }

    public int deleteById(final int post_id) {
        String sql = "DELETE FROM " + tableName + " WHERE id = ?";
        return jdbcTemplate.update(sql, post_id);
    }
}
