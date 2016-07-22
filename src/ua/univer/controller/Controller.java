package ua.univer.controller;

import ua.univer.controller.commands.Command;
import ua.univer.controller.commands.CommandFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Controller extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IRequestWrapper wrapper = new RequestWrapper(request);
        CommandFactory factory = CommandFactory.getInstance();
        Command command = factory.getCommand(wrapper);
        String viewPath = command.execute(wrapper);
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);
    }
}
