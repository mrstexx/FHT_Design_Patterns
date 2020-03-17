package edu.dp.states;

public enum EGameState {
    PURCHASED("Purchased"),
    DOWNLOADED("Downloaded"),
    INSTALL("installed"),
    UNINSTALL("uninstalled"),
    PLAYING("playing"),
    UPDATED("updated");

    String state = null;

    EGameState(String state) {
        this.state = state;
    }

    public String getValue() {
        return this.state;
    }
}
