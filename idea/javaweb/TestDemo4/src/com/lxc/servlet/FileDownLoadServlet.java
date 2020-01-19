package com.lxc.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet("/filedownload")
public class FileDownLoadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException {

        //获取url中的参数
        String filename = req.getParameter("filename");
        if (filename != null && !filename.equals("")) {
            ServletContext context = this.getServletContext();
            //查找文件
            String filepath = context.getRealPath("/file/" + filename);
            try {
                //获取文件输入流
                FileInputStream fis = new FileInputStream(filepath);

                //解决下载文件时中文不能正常显示
                String agent = req.getHeader("user-agent");
                String downloadFilename = DownLoadUntil.getFileName(agent, filename);
                System.out.println(downloadFilename);

                //设置头信息
                String mime = context.getMimeType(filename);
                resp.setContentType(mime);
                resp.setHeader("content-disposition", "attachment;filename="+downloadFilename);

                //获取Servlet输出流
                ServletOutputStream sos = resp.getOutputStream();
                //读取文件输入流中的数据，写入到Servlet输出流中
                byte[] ch = new byte[1024 * 10];
                int len = 0;
                while ((len = fis.read(ch)) != -1) {
                    sos.write(ch, 0, len);
                }
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
                //文件未读取成功
                try {
                    resp.setContentType("text/html;charset=utf-8");
                    PrintWriter writer = resp.getWriter();
                    writer.write("文件名错误，请重新输入。");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        } else {
            try {
                resp.setContentType("text/html;charset=utf-8");
                PrintWriter writer = resp.getWriter();
                writer.write("文件路径为空，请重新输入。");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
