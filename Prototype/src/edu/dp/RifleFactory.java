package edu.dp;

import edu.dp.rifle.Rifle;

import java.util.Map;

public class RifleFactory {

    private static RifleFactory rifleFactory;
    private static Map<String, Rifle> prototypes;

    private RifleFactory() {

    }

    public static Rifle getInstance(String rifleType) {
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