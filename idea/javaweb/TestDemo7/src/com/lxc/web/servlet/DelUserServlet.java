package com.lxc.web.servlet;

import com.lxc.service.UserService;
import com.lxc.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deluser")
public class DelUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取数据
        int id = 0;
        try {
            id = Integer.parseInt(req.getParameter("id"));
        }catch (Exception e){
            e.printStackTrace();
            //删除失败
        }
        System.out.println("deluser--id-->"+ id);
        UserService userService = new UserServiceImpl();
        boolean delUserRe = userService.delUser(id);
        if (delUserRe){
            resp.setStatus(302);
            resp.setHeader("location", "userservlet");
        }else{
            resp.setStatus(302);
            resp.setHeader("location", "userservlet");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
