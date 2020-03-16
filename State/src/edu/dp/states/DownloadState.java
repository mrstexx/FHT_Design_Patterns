package edu.dp.states;

import edu.dp.Game;
import edu.dp.IGameState;

public class DownloadState implements IGameState {
    @Override
    public void buyGame(Game game) {
        System.out.println("Game already purchased");
    }

    @Override
    public void downloadGame(Game game) {
        System.out.println("Downloading game...");
        game.setCurrentState(new DownloadState());
    }

    @Override
    public void installGame(Game game) {
        System.out.println("Download -> Install");
        game.setCurrentState(new InstallState());
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
