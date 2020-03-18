package edu.dp.states;

import edu.dp.Game;

public class UpdateState implements IState {

    @Override
    public void buyGame(Game game) {
        System.out.println("Game already purchased");
    }

    @Override
    public void downloadGame(Game game) {
        System.out.println("Game already installed");
    }

    @Override
    public void installGame(Game game) {
        System.out.println("Game already installed");
    }

    @Override
    public void uninstallGame(Game game) {
        game.setCurrentState(new UninstallState());
        System.out.println("Update -> Uninstall");
    }

    @Override
    public void updateGame(Game game) {
        System.out.println("Game already updated.");
    }

    @Override
    public void playGame(Game game) {
        game.setCurrentState(new PlayState());
        System.out.println("Update -> Play");
    }
}
