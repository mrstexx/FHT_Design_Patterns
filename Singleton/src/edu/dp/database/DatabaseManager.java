package edu.dp.database;

import edu.dp.AbstractManager;
import edu.dp.IManager;

public class DatabaseManager extends AbstractManager {
    private static DatabaseManager dbManager;

    private DatabaseManager() {
        super();
    }

    public void save() {
        System.out.println("Data successfully stored.");
    }

    public synchronized static IManager getInstance() {
        // simple example to show using Singleton registry
        if (dbManager == null) {
            dbManager = new DatabaseManager();
        }
        return dbManager;
    }
}
