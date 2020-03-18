package edu.dp.commands;

import edu.dp.Game;

public class UpdateCommand implements ICommand {

    private Game game;

    public UpdateCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        game.updateGame();
    }
}
