package ua.univer.controller.commands;

import ua.univer.controller.IRequestWrapper;
import ua.univer.controller.dao.DAOFactory;
import ua.univer.controller.dao.UserDao;
import ua.univer.controller.entity.User;

import javax.servlet.http.HttpSession;

public class RegistrationCommand implements Command {
    @Override
    public String execute(IRequestWrapper wrapper) {
        String name = wrapper.getParameter("name");
        String login = wrapper.getParameter("login");
        String password = wrapper.getParameter("password");
        HttpSession session = wrapper.getSession(true);

        DAOFactory factory = DAOFactory.getInstance();
        UserDao userDao = factory.getUserDAO();

        User user = userDao.getUserByLogin(login);
        if (user == null) {
            user = new User();
            user.setName(name);
            user.setLogin(login);
            user.setPassword(password);
            userDao.saveUser(user);
            return "/index.html";
        } else {
            session.setAttribute("incorrect", true);
            return "/registration.jsp";
        }
    }
}
