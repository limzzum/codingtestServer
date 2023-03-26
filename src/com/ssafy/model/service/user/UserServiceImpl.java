package com.ssafy.model.service.user;

import com.ssafy.model.dao.user.UserDao;
import com.ssafy.model.dao.user.UserDaoImpl;
import com.ssafy.model.dto.user.User;

public class UserServiceImpl implements UserService {
    private static UserService userService = new UserServiceImpl();
    private UserDao userDao;

    public static UserService getUserService(){
        return userService;
    }

    private UserServiceImpl(){
        this.userDao = UserDaoImpl.getUserDao();
    }

    @Override
    public User login(String id, String password) throws Exception {
        User user = userDao.selectById(id);

        if(password.equals(user.getPassword())){
            return user;
        }

        return null;
    }

    @Override
    public String join(User user) throws Exception {
        return null;
    }

    @Override
    public String leave() throws Exception {
        return null;
    }
}
