package edu.dp;

import com.google.gson.Gson;
import edu.dp.rifle.ERifleType;
import edu.dp.rifle.Rifle;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class RifleStore {

    private static Map<String, Rifle> prototypes;
    private static final String CONFIG_FILE = "config.json";

    static {
        loadConfig();
    }

    private static void loadConfig() {
        prototypes = new HashMap<>();
        Gson gson = new Gson();
        try {
            Reader reader = Files.newBufferedReader(Paths.get(CONFIG_FILE));
            // convert JSON file to map
            Map<String, Rifle> map = gson.fromJson(reader, Map.class);
            // iterate through map to take values
            for (Map.Entry<?, ?> entry : map.entrySet()) {
                String className = ERifleType.getClassName(entry.getKey().toString());
                Class clazz = Class.forName(className);
                String value = gson.toJson(entry.getValue());
                prototypes.put(entry.getKey().toString(), (Rifle) gson.fromJson(value, clazz));
            }
            // close reader
            reader.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public synchronized static Rifle getInstance(String rifleType) {
        Rifle rifle = null;
        rifle = prototypes.get(rifleType);
        if (rifle != null) {
            try {
                return rifle.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}