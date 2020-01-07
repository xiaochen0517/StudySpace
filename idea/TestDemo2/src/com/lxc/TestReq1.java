package com.lxc;

import javax.print.DocFlavor;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/testreq1")
public class TestReq1 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        BufferedReader reader = req.getReader();
        char[] chars = new char[1024];
        int len = 0;

        while ((len = reader.read(chars)) != -1){
            System.out.println(new String(chars, 0, len));
        }
        reader.close();
    }
}
