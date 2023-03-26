package com.ssafy.model.service.user;

import com.ssafy.model.dto.user.User;

public interface UserService {
    User login(String id,String password) throws Exception;
    String join(User user) throws Exception;
    String leave() throws Exception;
}
