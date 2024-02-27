package com.example.demo.DAOs;

import com.example.demo.models.Post;
import com.example.demo.models.joins.PostWithCategory;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.lang.NonNull;
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
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Post.class));
    }

    public int create(@NonNull Post post) {
        String sql =
            "INSERT INTO " +
            tableName +
            "(title, background, userID, mainContent, hashtag, isPrivate)" +
            " VALUES (?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(
            sql,
            post.getTitle(),
            post.getBackground(),
            post.getUserID(),
            post.getMainContent(),
            post.getHashtag(),
            post.getIsPrivate()
        );
    }

    public Post findById(int post_id) {
        String sql = "SELECT * FROM " + tableName + " WHERE id = ?";
        List<Post> posts = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Post.class), post_id);
        return posts.size() == 0 ? null : posts.get(0);
    }

    public int deleteById(int post_id) {
        String sql = "DELETE FROM " + tableName + " WHERE id = ?";
        return jdbcTemplate.update(sql, post_id);
    }

    public void updateCategory(int post_id, String category) {
        String sql = "UPDATE " + tableName + " SET categoryID = ?" + " WHERE id = ?";
        jdbcTemplate.update(sql, category, post_id);
    }

    public List<PostWithCategory> findPostWithCategory(int post_id) {
        String sql =
            "SELECT [posts].title, [posts].userID, [posts].categoryID, [categories].id AS mainCategoryID, [categories].[name]" +
            " FROM [posts] INNER JOIN [categories] ON [posts].[categoryID]=[categories].[id]" +
            " WHERE [posts].id = ?";
        List<PostWithCategory> post = jdbcTemplate.query(
            sql,
            BeanPropertyRowMapper.newInstance(PostWithCategory.class),
            post_id
        );
        return post;
    }

    public int deleteByCategory(String category) {
        String sql = "DELETE FROM " + tableName + " WHERE categoryID = ?";
        return jdbcTemplate.update(sql, category);
    }
}
