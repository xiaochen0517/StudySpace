package com.lxc.web.servlet;

import com.lxc.service.UserService;
import com.lxc.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delselected")
public class DelSelectedServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String[] uids = req.getParameterValues("uid");
        UserService userService = new UserServiceImpl();
        for (String idstr :uids){
            int id = Integer.parseInt(idstr);
            //删除数据
            userService.delUser(id);
        }
        //刷新数据
        resp.setStatus(302);
        resp.setHeader("location", "userservlet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
