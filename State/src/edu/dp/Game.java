package edu.dp;

public class Game {

    private IGameState currentState;
    private String gameName;

    public Game(String gameName) {
        this.gameName = gameName;
    }

    public IGameState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(IGameState currentState) {
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
