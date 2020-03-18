package edu.dp.commands;

import edu.dp.Game;

public class UninstallCommand implements ICommand {

    private Game game;

    public UninstallCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        game.uninstallGame();
    }
}
