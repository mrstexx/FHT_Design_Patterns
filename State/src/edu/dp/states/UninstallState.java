package edu.dp.states;

import edu.dp.Game;
import edu.dp.IGameState;

public class UninstallState implements IGameState {
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
        System.out.println("Uninstall -> Install");
        game.setCurrentState(new InstallState());
    }

    @Override
    public void uninstallGame(Game game) {
        System.out.println("Game already uninstalled");
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
