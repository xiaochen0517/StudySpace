package com.lxc.web.servlet;

import com.lxc.service.UserService;
import com.lxc.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        //判断验证码
        String verifycode = req.getParameter("verifycode");

        HttpSession session = req.getSession();
        if (!verifycode.equalsIgnoreCase((String) session.getAttribute("identcode"))){
            req.setAttribute("login_msg", "验证码错误！");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
            return;
        }

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        UserService userService = new UserServiceImpl();
        boolean b = userService.userLogin(username, password);
        if (b){
            //登录成功
            session.setAttribute("username", username);
            resp.setStatus(302);
            resp.setHeader("location", "userservlet");
            return;
        }else{
            //登录失败
            req.setAttribute("login_msg", "用户名或密码错误！");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
            return;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
