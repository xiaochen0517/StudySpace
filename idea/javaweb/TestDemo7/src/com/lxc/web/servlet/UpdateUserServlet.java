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

@WebServlet("/updateuser")
public class UpdateUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String emaile = "[a-zA-Z0-9]*@[a-zA-Z0-9]*\\.[a-zA-Z]*";
        //获取数据
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
        String age = req.getParameter("age");
        String address = req.getParameter("address");
        String qq = req.getParameter("qq");
        String email = req.getParameter("email");
        //判断数据
        System.out.println(name + "\n" + sex + "\n" + age + "\n" + address + "\n" + qq + "\n" + email);
        try {
            if (Integer.parseInt(id)<=0){
                //id错误
                req.setAttribute("update_msg", "id错误");
                req.getRequestDispatcher("finduser").forward(req,resp);
                return;
            }else if (name.length() <= 0 || name.length() > 10) {
                //用户名错误
                req.setAttribute("update_msg", "用户名错误");
                req.getRequestDispatcher("finduser").forward(req,resp);
                return;
            } else if (!sex.equals("男") && !sex.equals("女")) {
                //性别错误
                req.setAttribute("update_msg", "性别错误");
                req.getRequestDispatcher("finduser").forward(req,resp);
                return;
            } else if (Integer.parseInt(age) <= 0 || Integer.parseInt(age) > 150) {
                //年龄错误
                req.setAttribute("update_msg", "年龄错误");
                req.getRequestDispatcher("finduser").forward(req,resp);
                return;
            }else if (address.length()>20||address.length()<=0){
                //地址错误
                req.setAttribute("update_msg", "地址错误");
                req.getRequestDispatcher("finduser").forward(req,resp);
                return;
            }else if (Long.parseLong(qq)<=10000){
                //qq错误
                req.setAttribute("update_msg", "qq错误");
                req.getRequestDispatcher("finduser").forward(req,resp);
                return;
            }else if (!email.matches(emaile)){
                //邮箱错误
                req.setAttribute("update_msg", "邮箱错误");
                req.getRequestDispatcher("finduser").forward(req,resp);
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
            //数据验证错误
            req.setAttribute("update_msg", "数据验证错误");
            req.getRequestDispatcher("finduser").forward(req,resp);
            return;
        }
        //修改数据
        //写入数据库
        User user = new User();
        user.setName(name);
        user.setGender(sex);
        user.setAge(Integer.parseInt(age));
        user.setAddress(address);
        user.setQq(qq);
        user.setEmail(email);
        UserService userService = new UserServiceImpl();
        boolean udpateUserRe = userService.updateUser(user,Integer.parseInt(id));
        if (udpateUserRe){
            req.setAttribute("update_msg", "");
            resp.setStatus(302);
            resp.setHeader("location", "userservlet");
        }else{
            req.setAttribute("update_msg", "修改错误");
            req.getRequestDispatcher("finduser").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
