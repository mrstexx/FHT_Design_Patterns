package edu.dp.states;

import edu.dp.Game;
import edu.dp.IGameState;

public class PlayState implements IGameState {
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
        System.out.println("Game already installed");
    }

    @Override
    public void uninstallGame(Game game) {
        game.setCurrentState(new UninstallState());
        System.out.println("Closing game, Play -> Uninstall");
    }

    @Override
    public void updateGame(Game game) {
        game.setCurrentState(new UpdateState());
        System.out.println("Closing game, Play -> Update");
    }

    @Override
    public void playGame(Game game) {
        System.out.println("Game already started");
    }
}
