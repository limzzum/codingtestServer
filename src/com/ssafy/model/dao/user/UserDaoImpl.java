package com.ssafy.model.dao.user;

import com.ssafy.model.dto.user.User;
import com.ssafy.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao{
    private static  UserDao userDao = new UserDaoImpl();
    public static UserDao getUserDao() {
        return userDao;
    }


    @Override
    public User selectById(String id) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        StringBuilder sql = new StringBuilder();
        sql.append("select * from user");
        sql.append(" where id=?");
        User user = new User();

        try{
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql.toString());
            preparedStatement.setString(1,id);
            resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                user = User.builder()
                        .id(resultSet.getString("id"))
                        .password(resultSet.getString("password"))
                        .name(resultSet.getString("name"))
                        .address(resultSet.getString("address"))
                        .build();
            }
        }
        finally {
            DBUtil.close(resultSet,preparedStatement,connection);
        }

        return user;
    }

    @Override
    public int insertByUser(User user) throws SQLException {
        return 0;
    }

    @Override
    public int deleteById(String id) throws SQLException {
        return 0;
    }

    @Override
    public int updateByUser(User user) throws SQLException {
        return 0;
    }
}
