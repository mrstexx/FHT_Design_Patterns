package edu.dp.commands;

import edu.dp.Game;

public class PlayCommand implements ICommand {

    private Game game;

    public PlayCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        game.playGame();
    }
}
