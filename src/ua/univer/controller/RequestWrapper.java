package ua.univer.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class RequestWrapper implements IRequestWrapper {
    private HttpServletRequest request;

    public RequestWrapper(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public String getParameter(String key) {
        return request.getParameter(key);
    }

    @Override
    public HttpSession getSession(Boolean flag) {
        return request.getSession(flag);
    }

}
