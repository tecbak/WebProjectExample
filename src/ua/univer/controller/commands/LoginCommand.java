package ua.univer.controller.commands;

import ua.univer.controller.IRequestWrapper;
import ua.univer.controller.dao.DAOFactory;
import ua.univer.controller.dao.UserDao;
import ua.univer.controller.entity.User;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class LoginCommand implements Command {
    @Override
    public String execute(IRequestWrapper wrapper) {
        HttpSession session = wrapper.getSession(true);
        DAOFactory factory = DAOFactory.getInstance();
        UserDao userDao = factory.getUserDAO();

        Boolean login1 = (Boolean) session.getAttribute("login");
        if (login1 != null && login1) {
            List<User> users = userDao.getAll();
            List<String> userNames = new ArrayList<>();

            for (User user1 : users) {
                userNames.add(user1.getName());
            }

            session.removeAttribute("incorrectLogin");
            session.setAttribute("login", true);
            session.setAttribute("users", userNames);
            return "/WEB-INF/user.jsp";
        }
        String login = wrapper.getParameter("login");
        String password = wrapper.getParameter("password");


        User user = userDao.getUserByLogin(login);

        if (user != null && user.getPassword().equals(password)) {
            List<User> users = userDao.getAll();
            List<String> userNames = new ArrayList<>();

            for (User user1 : users) {
                userNames.add(user1.getName());
            }

            session.removeAttribute("incorrectLogin");
            session.setAttribute("login", true);
            session.setAttribute("users", userNames);
            return "/WEB-INF/user.jsp";
        } else {
            session.setAttribute("incorrectLogin", true);
            return "/login.jsp";
        }
    }
}
