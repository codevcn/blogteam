package com.example.demo.DAOs;

import com.example.demo.models.Interaction;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public class InteractionDAO {

    private final String tableName = "interactions";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int count() {
        String sql = "SELECT COUNT(*) FROM " + tableName;
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count == null ? 0 : count;
    }

    public List<Interaction> findAll() {
        String sql = "SELECT * FROM " + tableName;
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Interaction.class));
    }

    public int create(final @NonNull Interaction interaction) {
        String sql = "INSERT INTO " + tableName + "(postID, userID, liked)" + " VALUES (?, ?, ?)";
        return jdbcTemplate.update(
            sql,
            interaction.getPostID(),
            interaction.getUserID(),
            interaction.isLiked()
        );
    }

    public Interaction findOne(int post_id, String user_id) {
        String sql = "SELECT * FROM " + tableName + " WHERE postID = ? AND userID = ?";
        List<Interaction> interactions = jdbcTemplate.query(
            sql,
            BeanPropertyRowMapper.newInstance(Interaction.class),
            post_id,
            user_id
        );
        return interactions.size() == 0 ? null : interactions.get(0);
    }
}
