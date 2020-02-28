package edu.dp;

import java.util.HashMap;
import java.util.Map;

public class ManagerRegistry {
    private static ManagerRegistry registry;
    private Map<String, IManager> registryHolder = new HashMap<>();

    static {
        try {
            // create at the time of class loading
            // use static initialisation pattern here
            registry = new ManagerRegistry();
        } catch (Exception e) {
            throw new RuntimeException("An error occurred in creating manager registry instance.");
        }
    }

    public static ManagerRegistry getInstance() {
        synchronized (ManagerRegistry.class) {
            return registry;
        }
    }

    private boolean isRegistered(final String name) {
        return registryHolder.containsKey(name);
    }

    private void setManager(IManager manager) {
        synchronized (ManagerRegistry.class) {
            registryHolder.put(manager.getClass().getName(), manager);
        }
    }

    private void unsetManager(IManager manager) {
        synchronized (ManagerRegistry.class) {
            if (!isRegistered(manager.getClass().getName())) {
                return;
            }
            registryHolder.remove(manager.getClass().getName());
        }
    }

    /**
     * Get manager
     *
     * @param managerClass Manager class to get
     * @return registered manager or null if not existing
     */
    public IManager getManager(Class<?> managerClass) {
        synchronized (ManagerRegistry.class) {
            if (isRegistered(managerClass.getName())) {
                return registryHolder.get(managerClass.getName());
            }
            return null;
        }
    }

    /**
     * Register manager to registry
     *
     * @param manager Manager to be registered
     */
    public static void register(IManager manager) {
        getInstance().setManager(manager);
    }

    /**
     * Unregister manager from registry
     *
     * @param manager Manager to be unregistered
     */
    public static void unregister(IManager manager) {
        getInstance().unsetManager(manager);
    }
}
