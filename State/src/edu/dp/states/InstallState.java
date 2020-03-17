package edu.dp.states;

import edu.dp.Game;

public class InstallState implements IState {
    @Override
    public void buyGame(Game game) {
        System.out.println("Game already purchased");
    }

    @Override
    public void downloadGame(Game game) {
        System.out.println("Game already downloaded");
    }

    @Override
    public void installGame(Game game) {
        System.out.println("Installing game...");
        game.setCurrentState(new InstallState());
    }

    @Override
    public void uninstallGame(Game game) {
        System.out.println("Install -> Uninstall");
        game.setCurrentState(new UninstallState());
    }

    @Override
    public void updateGame(Game game) {
        System.out.println("Install -> Update");
        game.setCurrentState(new UpdateState());
    }

    @Override
    public void playGame(Game game) {
        System.out.println("Install -> Play");
        game.setCurrentState(new PlayState());
    }
}
