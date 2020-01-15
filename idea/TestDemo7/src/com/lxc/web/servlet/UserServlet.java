package com.lxc.web.servlet;

import com.lxc.domain.Page;
import com.lxc.domain.Search;
import com.lxc.domain.User;
import com.lxc.service.UserService;
import com.lxc.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/userservlet")
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        //获取数据
        int pageCount = 1;
        int rowsCount = 10;
        String pageCountStr = req.getParameter("pageCount");
        String rowsCountStr = req.getParameter("rowsCount");
        if (pageCountStr != null && rowsCountStr != null &&
                !pageCountStr.equals("") && !rowsCountStr.equals("")) {
            pageCount = Integer.parseInt(pageCountStr);
            rowsCount = Integer.parseInt(rowsCountStr);
        }
        //计算开始索引
        int startCount = (pageCount - 1) * rowsCount;
        UserService userService = new UserServiceImpl();

        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String email = req.getParameter("email");
        Search search = new Search();
        search.setName("");
        search.setAddress("");
        search.setEmail("");
        if (name != null) search.setName(name);
        if (address != null) search.setAddress(address);
        if (email != null) search.setEmail(email);
        List<User> user = userService.findSearchUser(startCount, rowsCount, search);
        //获取分页数据
        int allRowsCount = userService.findSearchRowsCount(search);
        //总页数
        Page page = new Page();
        page.setAllRowsCount(allRowsCount);
        page.setAllPageCount(allRowsCount % rowsCount == 0 ? allRowsCount / rowsCount : allRowsCount / rowsCount + 1);
        page.setLocaPageCount(pageCount);

        req.setAttribute("search", search);
        req.setAttribute("users", user);
        req.setAttribute("page", page);
        req.getRequestDispatcher("/list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
