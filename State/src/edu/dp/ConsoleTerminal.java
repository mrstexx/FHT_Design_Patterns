package edu.dp;

import edu.dp.commands.ECommands;
import edu.dp.commands.ICommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class ConsoleTerminal {

    private Game currentGame;
    private boolean isTerminated = false;
    private boolean isGameShowed = false;

    public void init() {
        if (!isGameShowed) {
            showGamePage();
        } else {
            showCommandPage(currentGame);
        }
    }

    private void showCommandPage(Game game) {
        clearConsole();
        isGameShowed = true;
        System.out.println("***************** PiGameConsole Store *****************");
        System.out.println("List of available commands for game: " + game.getGameName());
        listCommands(game);
        showBackOption();
        readCommand(game);
    }

    private void showGamePage() {
        clearConsole();
        isGameShowed = false;
        System.out.println("**************** PiGameConsole Store *****************");
        System.out.println("List of available games: ");
        listGames();
        showBackOption();
        readGame();
    }

    public static void blankLine() {
        System.out.println("");
    }

    private void listGames() {
        Map<Integer, Game> allGames = EGames.getAllGames();
        allGames.forEach((id, game) -> {
            System.out.println(id + ". " + game.getGameName());
        });
    }

    private void listCommands(Game game) {
        Map<Integer, ICommand> allCommands = ECommands.getAllCommands(game);
        allCommands.forEach((id, command) -> {
            System.out.println(id + ". " + ECommands.getCommandTitle(id));
        });
    }

    private void showBackOption() {
        if (!isGameShowed) {
            System.out.println("\n0. Exit");
        } else {
            System.out.println("\n0. Back");
        }
    }

    private void readGame() {
        blankLine();
        System.out.print("Enter game ID: ");
        showGame(readInput());
    }

    private void readCommand(Game game) {
        blankLine();
        System.out.print("Enter command ID: ");
        proceedCommand(readInput(), game);
    }

    private void showGame(int gameID) {
        if (gameID == 0) {
            isTerminated = true;
            return;
        }
        if (EGames.getAllGames().size() < gameID) {
            System.out.println("Wrong gameID, please try again!");
            return;
        }
        clearConsole();
        Game game = EGames.getGame(gameID);
        if (game != null) {
            currentGame = game;
            showCommandPage(game);
        }
    }

    private void proceedCommand(int commandID, Game game) {
        if (commandID == 0) {
            clearConsole();
            isGameShowed = false;
        }
        if (commandID > ECommands.getAllCommands(game).size()) {
            System.out.println("Wrong command ID, please try again!");
            return;
        }
        ICommand command = ECommands.getCommand(game, commandID);
        if (command != null) {
            command.execute();
            System.out.println();
        }
    }

    public static int readInput() {
        String input = null;
        int number = 0;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            input = bufferedReader.readLine();
            number = Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            System.out.println("Not a number!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return number;
    }

    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public boolean isTerminated() {
        return this.isTerminated;
    }

}
