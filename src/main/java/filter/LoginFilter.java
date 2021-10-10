package filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.sql.ResultSet;

@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        String requestURI = req.getRequestURI();
        if (!requestURI.contains("/success.jsp")) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            String user = (String) req.getSession().getAttribute("user");
            if (user != null && user.length() != 0) {
                filterChain.doFilter(servletRequest, servletResponse);
            }else {
                req.setAttribute("login_msg","您尚未登陆");
                req.getRequestDispatcher("/login.jsp").forward(servletRequest,servletResponse);
            }
        }


    }
}
