package edu.dp;

import edu.dp.history.HistoryManager;

import java.time.LocalDateTime;
import java.util.Random;

public class MainExampleA {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            HistoryManager manager = (HistoryManager) HistoryManager.getInstance();
            manager.addEntry("User" + new Random().nextInt(), LocalDateTime.now());
        }
    }
}
