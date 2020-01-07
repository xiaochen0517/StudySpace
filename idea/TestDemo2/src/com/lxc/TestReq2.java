package com.lxc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet("/testreq2")
public class TestReq2 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);

        //解决中文乱码
        req.setCharacterEncoding("utf-8");

        System.out.println("post");
        System.out.println("username--"+req.getParameter("username"));
        System.out.println("password--"+req.getParameter("password"));
        System.out.println("commit--"+req.getParameter("commit"));

        System.out.println("------------------------");

        String[] checkboxs = req.getParameterValues("checkbox");
        for (String checkbox:checkboxs)
            System.out.println(checkbox);

        System.out.println("------------------------");

        Enumeration<String> keynames = req.getParameterNames();
        while (keynames.hasMoreElements()){
            String key = keynames.nextElement();
            String value = req.getParameter(key);
            System.out.println(key +"--"+ value);

        }

        Map<String, String[]> mapStrs = req.getParameterMap();
        Set<String> keys = mapStrs.keySet();
        for (String key : keys) {
            String[] values = mapStrs.get(key);
            for (String value : values) {
                System.out.println(key + "--" + value);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        System.out.println("get");
        System.out.println("username--" + req.getParameter("username"));
        System.out.println("password--" + req.getParameter("password"));
    }
}
