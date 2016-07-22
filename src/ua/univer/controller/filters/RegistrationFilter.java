package ua.univer.controller.filters;

import javax.servlet.*;
import java.io.IOException;

public class RegistrationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String name = servletRequest.getParameter("name");
        String login = servletRequest.getParameter("login");
        String password = servletRequest.getParameter("password");

        if (name == null || login == null || password == null) {
            servletRequest.setAttribute("incorrect", true);
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
