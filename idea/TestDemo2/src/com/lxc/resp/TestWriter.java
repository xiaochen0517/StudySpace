package com.lxc.resp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/testw")
public class TestWriter extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决中文乱码
        resp.setCharacterEncoding("utf-8");
        resp.setHeader("content-type", "text/html;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.write("你好！");
    }
}
