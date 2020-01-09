package com.lxc.context;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/testcontext")
public class TestContext extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取ServletContext
        ServletContext sc = this.getServletContext();
        //定义文件名
        String filename = "a.jpg";
        //使用文件名获取mime类型
        String mimeType = sc.getMimeType(filename);
        System.out.println(mimeType);
    }
}
