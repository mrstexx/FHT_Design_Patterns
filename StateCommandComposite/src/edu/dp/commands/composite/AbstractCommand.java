package edu.dp.commands.composite;

import edu.dp.commands.ICommand;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractCommand implements ICommand {

    private List<ICommand> childCommands = new ArrayList<>();

    protected void addCommand(ICommand command) {
        childCommands.add(command);
    }

    public void execute() {
        for (ICommand childCommand : childCommands) {
            childCommand.execute();
        }
    }

}
