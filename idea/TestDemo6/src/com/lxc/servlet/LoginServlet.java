package com.lxc.servlet;

import com.lxc.dao.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决乱码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //获取参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String identcode = req.getParameter("identcode");
        System.out.println("u:"+username);
        System.out.println("p:"+password);
        System.out.println("i:"+identcode);
        //判断验证码
        //读取
        HttpSession session = req.getSession();
        String identcodese = (String) session.getAttribute("identcode");
        if (identcode.equalsIgnoreCase(identcodese)){
            //验证码正确
            User user = new User();
            if (password.equals(user.getPassword(username))){
                //成功登录
                System.out.println("登录成功");
                //将数据写入session
                session.setAttribute("username", username);
                resp.setStatus(302);
                resp.setHeader("location","home.jsp");
            }else{
                //用户名密码错误
                PrintWriter writer = resp.getWriter();
                writer.write("用户名或密码错误");
            }
        }else{
            PrintWriter writer = resp.getWriter();
            writer.write("验证码错误");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
