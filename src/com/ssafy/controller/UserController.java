package com.ssafy.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssafy.model.dto.user.User;
import com.ssafy.model.service.user.UserService;
import com.ssafy.model.service.user.UserServiceImpl;
import com.ssafy.util.ControllerUtil;
import org.json.JSONObject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserController implements Controller{
    UserService userService = UserServiceImpl.getUserService();
    ControllerUtil controllerUtil = ControllerUtil.getControllerUtil();
    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JSONObject jsonObject = new JSONObject(controllerUtil.readBody(request));
        String action = jsonObject.getString("action");
        String path="";
        try{
            if("login".equals(action)){
                login(request,response,jsonObject);
            }else if("logout".equals(action)){
                logout(request);
            }

        }catch (Exception e){
            e.printStackTrace();
            throw new ServletException();
        }
    }

    public void login(HttpServletRequest request,HttpServletResponse response,JSONObject jsonObject) throws Exception {
        JSONObject jsonUser = jsonObject.getJSONObject("user");

        String id = jsonUser.getString("id");
        String password = jsonUser.getString("password");

        User user = userService.login(id,password);
        ObjectMapper objectMapper = new ObjectMapper();
        String json ="{\"id\" : \"FAIL\"}";

        if(user!=null){
            HttpSession session = request.getSession();
            session.setAttribute("userInfo",user);
            json = objectMapper.writeValueAsString(user);
        }
        response.getWriter().write(json);
    }

    public void logout(HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        session.invalidate();
    }

}
