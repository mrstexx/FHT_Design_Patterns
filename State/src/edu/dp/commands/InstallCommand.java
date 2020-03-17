package edu.dp.commands;

import edu.dp.Game;

public class InstallCommand implements ICommand {

    private Game game;

    public InstallCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        game.installGame();
    }
}
