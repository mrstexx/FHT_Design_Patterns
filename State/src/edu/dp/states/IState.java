package edu.dp.states;

import edu.dp.Game;

public interface IState {
    public void buyGame(Game game);

    public void downloadGame(Game game);

    public void installGame(Game game);

    public void uninstallGame(Game game);

    public void updateGame(Game game);

    public void playGame(Game game);
}
