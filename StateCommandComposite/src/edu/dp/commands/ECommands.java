package edu.dp.commands;

import edu.dp.Game;
import edu.dp.commands.composite.BuyAndDownloadCommand;
import edu.dp.commands.composite.OneClickPlayCommand;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum ECommands {
    BUY(1, "Buy Game", BuyCommand.class),
    DOWN(2, "Download Game", DownloadCommand.class),
    INSTALL(3, "Install Game", InstallCommand.class),
    PLAY(4, "Play Game", PlayCommand.class),
    UPDATE(5, "Get Updates", UpdateCommand.class),
    UNINST(6, "Uninstall Game", UninstallCommand.class),
    BUY_AND_DOWNLOAD(7, "Buy and Download Game", BuyAndDownloadCommand.class),
    ONE_CLICK(8, "One click play", OneClickPlayCommand.class);

    private int commandID;
    private String commandLabel;
    private Class<?> command;
    private static Map<Integer, ICommand> allCommands = null;

    ECommands(int commandID, String commandLabel, Class<?> command) {
        this.commandID = commandID;
        this.commandLabel = commandLabel;
        this.command = command;
    }

    public Class<?> getCommandClass() {
        return command;
    }

    public int getCommandID() {
        return commandID;
    }

    public String getCommandLabel() {
        return commandLabel;
    }

    public static String getCommandTitle(int cmdID) {
        for (ECommands cmdItem : ECommands.values()) {
            if (cmdID == cmdItem.commandID) {
                return cmdItem.getCommandLabel();
            }
        }
        return "No command name";
    }

    public static Map<Integer, ICommand> getAllCommands(Game game) {
        allCommands = new HashMap<>();
        Arrays.asList(ECommands.values()).forEach(cmd -> {
            allCommands.put(cmd.getCommandID(), createCommand(game, cmd));
        });
        return allCommands;
    }

    private static ICommand createCommand(Game game, ECommands cmd) {
        try {
            return (ICommand) cmd.getCommandClass().getDeclaredConstructor(Game.class).newInstance(game);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ICommand getCommand(Game game, int cmdID) {
        if (allCommands != null) {
            return allCommands.get(cmdID);
        }
        for (ECommands cmdItem : ECommands.values()) {
            if (cmdID == cmdItem.commandID) {
                return createCommand(game, cmdItem);
            }
        }
        return null;
    }
}
