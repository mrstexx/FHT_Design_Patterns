package edu.dp;

public class GameStore {

    ConsoleTerminal consoleTerminal;

    public void open() {
        consoleTerminal = new ConsoleTerminal();
        while (!consoleTerminal.isTerminated()) {
            // manage later different
            startSession();
        }
    }

    public void startSession() {
        consoleTerminal.init();
    }
}
