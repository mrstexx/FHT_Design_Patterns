package edu.dp.commands;

import edu.dp.Game;

public class DownloadCommand implements ICommand {

    private Game game;

    public DownloadCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        game.downloadGame();
    }
}
