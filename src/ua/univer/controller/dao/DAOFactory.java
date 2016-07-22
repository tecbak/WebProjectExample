package ua.univer.controller.dao;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DAOFactory {
    private static DAOFactory instance = new DAOFactory();
    UserDao userDao;
    DataSource source;

    {
        try {
            InitialContext context = new InitialContext();
            source = (DataSource) context.lookup("java:comp/env/jdbc/webdb");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    private DAOFactory() {
        userDao = new UserDao(source);
    }

    public synchronized static DAOFactory getInstance() {
        return instance;
    }

    public UserDao getUserDAO() {
        return userDao;
    }
}
