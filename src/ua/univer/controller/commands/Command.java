package ua.univer.controller.commands;

import ua.univer.controller.IRequestWrapper;

public interface Command {
    String execute(IRequestWrapper wrapper);
}
