package edu.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum EGames {
    LOL(1, new Game("League of Legends")),
    ROCKET_LEAGUE(2, new Game("Rocket League")),
    FORTNITE(3, new Game("Fortnite")),
    RDR_II(4, new Game("Red Dead Redemption II")),
    FIFA(5, new Game("FIFA 20"));

    private int gameID;
    private Game game;

    EGames(int id, Game game) {
        this.gameID = id;
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    public int getGameID() {
        return gameID;
    }

    public static Map<Integer, Game> getAllGames() {
        Map<Integer, Game> allGames = new HashMap<>();
        Arrays.asList(EGames.values()).forEach(game -> {
            allGames.put(game.getGameID(), game.getGame());
        });
        return allGames;
    }

    public static Game getGame(int gameID) {
        for (EGames gameItem : EGames.values()) {
            if (gameID == gameItem.gameID) {
                return gameItem.game;
            }
        }
        return null;
    }
}
