package com.lxc.web.servlet;

import com.lxc.domain.User;
import com.lxc.service.UserService;
import com.lxc.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.IdentityHashMap;

@WebServlet("/finduser")
public class FindUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取数据
        int id = 0;
        try {
            id = Integer.parseInt(req.getParameter("id"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        UserService userService = new UserServiceImpl();
        User user = userService.findUser(id);
        if (user == null || user.getName() == null|| user.getName().equals("")){
            //获取user错误
            resp.setStatus(302);
            resp.setHeader("location", "userservlet");
            return;
        }
        req.setAttribute("edituser", user);
        req.setAttribute("editid", id);
        req.getRequestDispatcher("update.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
