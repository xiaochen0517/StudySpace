package com.lxc.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/access")
public class AccessServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决中文乱码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //是否第一次访问
        boolean firstAccess = true;
        //获取当前时间
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        String nowTime = sdf.format(d);
        System.out.println("当前时间：" + nowTime);
        //获取cookie
        Cookie[] cookies = req.getCookies();
        if (cookies !=null){
            for (Cookie cookie:cookies){
                if (cookie.getName().equals("lastTime")){
                    //不是第一次访问
                    firstAccess = false;
                    //显示时间
                    PrintWriter writer = resp.getWriter();
                    writer.write("<h1>欢迎您，上次访问时间："+ URLDecoder.decode(cookie.getValue(), "utf-8")+"</h1>");
                    //刷新cookie
                    Cookie newCookie = new Cookie("lastTime", URLEncoder.encode(nowTime,"utf-8"));
                    cookie.setMaxAge(60*60*24*30);
                    resp.addCookie(newCookie);
                    break;
                }
            }
        }
        //第一次访问
        if (firstAccess){
            Cookie cookie = new Cookie("lastTime", URLEncoder.encode(nowTime,"utf-8"));
            cookie.setMaxAge(60*60*24*30);
            resp.addCookie(cookie);
            PrintWriter writer = resp.getWriter();
            writer.write("<h1>当前是您第一次访问本网站！</h1>");
        }
    }
}
