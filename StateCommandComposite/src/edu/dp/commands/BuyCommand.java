package edu.dp.commands;

import edu.dp.Game;

public class BuyCommand implements ICommand {

    private Game game;

    public BuyCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        game.buyGame();
    }
}
