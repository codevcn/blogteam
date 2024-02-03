package com.example.demo.DAOs;

import com.example.demo.models.Category;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDAO {

    private final String tableName = "categories";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int count() {
        String sql = "SELECT COUNT(*) FROM " + tableName;
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count == null ? 0 : count;
    }

    public List<Category> findAll() {
        String sql = "SELECT * FROM " + tableName;
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Category.class));
    }

    public int create(final @NonNull Category category) {
        String sql = "INSERT INTO " + tableName + "(id, [name], [description])" + " VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, category.getId(), category.getName(), category.getDescription());
    }

    public Category findById(String category_id) {
        String sql = "SELECT * FROM " + tableName + " WHERE id = ?";
        Category category = jdbcTemplate.queryForObject(
            sql,
            BeanPropertyRowMapper.newInstance(Category.class),
            category_id
        );
        return category;
    }

    public int deleteById(String category_id) {
        String sql = "DELETE FROM " + tableName + " WHERE id = ?";
        return jdbcTemplate.update(sql, category_id);
    }
}
