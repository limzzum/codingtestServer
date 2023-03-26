package com.ssafy.model.dao.user;

import com.ssafy.model.dto.user.User;

import java.sql.SQLException;

public interface UserDao {
    User selectById(String id) throws SQLException;

    int insertByUser(User user) throws SQLException;

    int deleteById(String id) throws SQLException;

    int updateByUser(User user) throws SQLException;
}
