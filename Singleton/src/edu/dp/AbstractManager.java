package edu.dp;

public abstract class AbstractManager implements IManager {
    public AbstractManager() {
        // register manager to manager registry
        ManagerRegistry.register(this);
    }
}
