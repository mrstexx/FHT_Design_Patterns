package edu.dp.states;

import edu.dp.Game;

public class NeutralState implements IState {
    @Override
    public void buyGame(Game game) {
        System.out.println("Game purchased");
        game.setCurrentState(new BuyState());
    }

    @Override
    public void downloadGame(Game game) {
        System.out.println("Game must be first purchased");
    }

    @Override
    public void installGame(Game game) {
        System.out.println("Game must be first purchased");
    }

    @Override
    public void uninstallGame(Game game) {
        System.out.println("Game must be first purchased");
    }

    @Override
    public void updateGame(Game game) {
        System.out.println("Game must be first purchased");
    }

    @Override
    public void playGame(Game game) {
        System.out.println("Game must be first purchased");
    }
}
