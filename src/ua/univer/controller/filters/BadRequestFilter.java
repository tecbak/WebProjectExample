package ua.univer.controller.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BadRequestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String path = ((HttpServletRequest) servletRequest).getRequestURI();
        if (path.equals("/registration.jsp") ||
                path.equals("/login.jsp") ||
                path.equals("/index.html") ||
                path.equals("/") ||
                path.equals("/controllerLogin") ||
                path.equals("/controllerRegistration")) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            String contextPath = ((HttpServletRequest) servletRequest).getContextPath();
            ((HttpServletResponse) servletResponse).sendRedirect(contextPath + "/error.html");
        }
    }

    @Override
    public void destroy() {

    }
}
