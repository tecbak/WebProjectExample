package ua.univer.controller;

import javax.servlet.http.HttpSession;

public interface IRequestWrapper {
    String getParameter(String key);

    HttpSession getSession(Boolean flag);
}
