package com.example.demo.DAOs;

import com.example.demo.models.Search;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public class SearchDAO {

    private final String tableName = "searches";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int count() {
        String sql = "SELECT COUNT(*) FROM " + tableName;
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count == null ? 0 : count;
    }

    public List<Search> findAll() {
        String sql = "SELECT * FROM " + tableName;
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Search.class));
    }

    public int create(final @NonNull Search search) {
        String sql = "INSERT INTO " + tableName + "(postID, createdAt)" + " VALUES (?, ?)";
        return jdbcTemplate.update(sql, search.getPostID(), search.getCreatedAt());
    }

    public Search findById(int search_id) {
        String sql = "SELECT * FROM " + tableName + " WHERE id = ?";
        List<Search> searches = jdbcTemplate.query(
            sql,
            BeanPropertyRowMapper.newInstance(Search.class),
            search_id
        );
        return searches.size() == 0 ? null : searches.get(0);
    }

    public int deleteById(int search_id) {
        String sql = "DELETE FROM " + tableName + " WHERE id = ?";
        return jdbcTemplate.update(sql, search_id);
    }
}
