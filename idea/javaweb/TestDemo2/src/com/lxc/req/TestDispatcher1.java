package com.lxc.req;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/dispatcher1")
public class TestDispatcher1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get dispatcher1");
        //转发
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/dispatcher2");
//        requestDispatcher.forward(req, resp);

        /**
         * 共享数据
         */

        //添加数据
        req.setAttribute("msg", "Hello World!");
        //转发
        req.getRequestDispatcher("/dispatcher2").forward(req, resp);
    }
}
