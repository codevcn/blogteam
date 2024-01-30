package com.example.demo.models.mappers;

import com.example.demo.models.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

public class UserMapper implements RowMapper<User> {

    @Override
    @Nullable
    public User mapRow(@NonNull ResultSet rss, int rowNum) throws SQLException {
        User user = new User();
        user.setEmail(rss.getString("email"));
        user.setCreatedAt(rss.getString("createdAt"));
        user.setAddress(rss.getString("address"));
        user.setBirthday(rss.getString("birthday"));
        user.setGender(rss.getString("gender"));
        user.setFullName(rss.getString("fullName"));
        user.setPassword(rss.getString("password"));
        user.setRole(rss.getString("role"));
        user.setAvatar(rss.getString("avatar"));
        return user;
    }
}
