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
import java.math.BigInteger;
import java.util.Enumeration;

@WebServlet("/adduser")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String emaile = "[a-zA-Z0-9]*@[a-zA-Z0-9]*\\.[a-zA-Z]*";
        //获取数据
        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
        String age = req.getParameter("age");
        String address = req.getParameter("address");
        String qq = req.getParameter("qq");
        String email = req.getParameter("email");
        //检查数据合法性
        System.out.println(name + "\n" + sex + "\n" + age + "\n" + address + "\n" + qq + "\n" + email);
        try {
            if (name.length() <= 0 || name.length() > 10) {
                //用户名错误
                req.setAttribute("add_msg", "用户名错误");
                req.getRequestDispatcher("add.jsp").forward(req,resp);
                return;
            } else if (!sex.equals("男") && !sex.equals("女")) {
                //性别错误
                req.setAttribute("add_msg", "性别错误");
                req.getRequestDispatcher("add.jsp").forward(req,resp);
                return;
            } else if (Integer.parseInt(age) <= 0 || Integer.parseInt(age) > 150) {
                //年龄错误
                req.setAttribute("add_msg", "年龄错误");
                req.getRequestDispatcher("add.jsp").forward(req,resp);
                return;
            }else if (address.length()>2||address.length()<=0){
                //地址错误
                req.setAttribute("add_msg", "地址错误");
                req.getRequestDispatcher("add.jsp").forward(req,resp);
                return;
            }else if (Long.parseLong(qq)<=10000){
                //qq错误
                req.setAttribute("add_msg", "qq错误");
                req.getRequestDispatcher("add.jsp").forward(req,resp);
                return;
            }else if (!email.matches(emaile)){
                //邮箱错误
                req.setAttribute("add_msg", "邮箱错误");
                req.getRequestDispatcher("add.jsp").forward(req,resp);
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
            //数据验证错误
            req.setAttribute("add_msg", "数据验证错误");
            req.getRequestDispatcher("add.jsp").forward(req,resp);
            return;
        }
        //写入数据库
        User user = new User();
        user.setName(name);
        user.setGender(sex);
        user.setAge(Integer.parseInt(age));
        user.setAddress(address);
        user.setQq(qq);
        user.setEmail(email);
        UserService userService = new UserServiceImpl();
        boolean addUserRe = userService.addUser(user);
        if (addUserRe){
            req.setAttribute("add_msg", "");
            resp.setStatus(302);
            resp.setHeader("location", "userservlet");
        }else{
            req.setAttribute("add_msg", "添加错误");
            req.getRequestDispatcher("add.jsp").forward(req,resp);
        }
    }
}
