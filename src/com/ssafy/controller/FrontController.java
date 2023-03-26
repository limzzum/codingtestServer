package com.ssafy.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/trip/*")
public class FrontController extends HttpServlet {
    private static Map<String,Controller> controllerMap= new HashMap<>();

    //USER
    private static final String USER_URL = "/trip/trip/user";

    //COMMUNITY
    private static final String TIP_URL = "/trip/trip/community/tip";
    private static final String HOTPLACE_URL = "/trip/trip/community/hotplace";

    //PLAN

    @Override
    public void init() throws ServletException {
        super.init();
        controllerMap.put(USER_URL,new UserController());
        controllerMap.put(TIP_URL,new TipController());
        controllerMap.put(HOTPLACE_URL,new HotplaceController());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestUri = request.getRequestURI();
        Controller controller = controllerMap.get(requestUri);
        if(controller == null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        controller.process(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        doGet(request,response);
    }
}
