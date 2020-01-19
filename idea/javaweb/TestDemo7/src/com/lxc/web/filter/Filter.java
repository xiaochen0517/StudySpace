package com.lxc.web.filter;

import com.lxc.domain.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class Filter implements javax.servlet.Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        req.setCharacterEncoding("utf-8");
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String uri = request.getRequestURI();
        if (uri.contains("/login.jsp") ||
                uri.contains("login") ||
                uri.contains("/vcode") ||
                uri.contains("/css") ||
                uri.contains("/fonts") ||
                uri.contains("/js")) {
            //直接放行
            filterChain.doFilter(req, resp);
        } else {
            HttpSession session = ((HttpServletRequest) req).getSession();
            String username = (String) session.getAttribute("username");
            if (username == null || username.equals("")) {
                response.setStatus(302);
                response.setHeader("location", "login.jsp");
            } else {
                //登录验证成功
                filterChain.doFilter(req, resp);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
