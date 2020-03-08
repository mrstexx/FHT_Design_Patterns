package edu.dp.rifle;

public enum ERifleType {
    ASSAULT("assault", "edu.dp.rifle.AssaultRifle"),
    SNIPER("sniper", "edu.dp.rifle.SniperRifle");

    private String type;
    private String className;

    ERifleType(String type, String className) {
        this.type = type;
        this.className = className;
    }

    public static String getClassName(String code) {
        for (ERifleType rifle : ERifleType.values()) {
            if (rifle.type.equals(code)) {
                return rifle.className;
            }
        }
        return null;
    }

    public String getValue() {
        return type;
    }

}
