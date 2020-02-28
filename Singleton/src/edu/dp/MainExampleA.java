package edu.dp;

import edu.dp.database.DatabaseManager;
import edu.dp.history.HistoryManager;

import java.time.LocalDateTime;
import java.util.Random;

public class MainExampleA {
    public static void main(String[] args) {
        // History Manager - main exercise implementation
        HistoryManager manager = (HistoryManager) HistoryManager.getInstance();
        // or with HistoryManager.getInstance()
        for (int i = 0; i < 10; i++) {
            manager.addEntry("User" + new Random().nextInt(), LocalDateTime.now());
        }

        // Database Manager - not main impl, used just to show ussage of singleton registry class
        DatabaseManager dbManager = (DatabaseManager) DatabaseManager.getInstance();
        dbManager.save();
    }
}
