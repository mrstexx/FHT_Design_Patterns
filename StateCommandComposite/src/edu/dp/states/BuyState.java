package edu.dp.states;

import edu.dp.Game;

public class BuyState implements IState {

    @Override
    public void buyGame(Game game) {
        System.out.println("Game already purchased");
    }

    @Override
    public void downloadGame(Game game) {
        game.setCurrentState(new DownloadState());
        System.out.println("Buy -> Download");
    }

    @Override
    public void installGame(Game game) {
        System.out.println("Game must be first downloaded");
    }

    @Override
    public void uninstallGame(Game game) {
        System.out.println("Game must be first installed");
    }

    @Override
    public void updateGame(Game game) {
        System.out.println("Game must be first installed");
    }

    @Override
    public void playGame(Game game) {
        System.out.println("Game must be first installed");
    }
}
