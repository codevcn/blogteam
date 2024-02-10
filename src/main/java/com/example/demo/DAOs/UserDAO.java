package com.example.demo.DAOs;

import com.example.demo.models.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {

    private final String tableName = "users";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int count() {
        String sql = "SELECT COUNT(*) FROM " + tableName;
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count == null ? 0 : count;
    }

    public List<User> findAll() {
        String sql = "SELECT * FROM " + tableName;
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(User.class));
    }

    public int create(final @NonNull User user) {
        String sql =
            "INSERT INTO " +
            tableName +
            "(email,fullName,gender,[password],[role])" +
            " VALUES (?,?,?,?,?)";
        return jdbcTemplate.update(
            sql,
            user.getEmail(),
            user.getFullName(),
            user.getGender(),
            user.getPassword(),
            user.getRole()
        );
    }

    public User findById(String user_email) {
        String sql = "SELECT * FROM " + tableName + " WHERE email = ?";
        User user = jdbcTemplate.queryForObject(
            sql,
            BeanPropertyRowMapper.newInstance(User.class),
            user_email
        );
        return user;
    }

    public int deleteById(String user_email) {
        String sql = "DELETE FROM " + tableName + " WHERE email = ?";
        return jdbcTemplate.update(sql, user_email);
    }
}
