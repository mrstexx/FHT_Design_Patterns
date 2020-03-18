package edu.dp;

import edu.dp.states.IState;
import edu.dp.states.BaseState;

public class Game {

    private IState currentState;
    private String gameName;

    public Game(String gameName) {
        this.currentState = new BaseState();
        this.gameName = gameName;
    }

    public IState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(IState currentState) {
        this.currentState = currentState;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public void buyGame() {
        currentState.buyGame(this);
    }

    public void downloadGame() {
        currentState.downloadGame(this);
    }

    public void installGame() {
        currentState.installGame(this);
    }

    public void playGame() {
        currentState.playGame(this);
    }

    public void uninstallGame() {
        currentState.uninstallGame(this);
    }

    public void updateGame() {
        currentState.updateGame(this);
    }
}
