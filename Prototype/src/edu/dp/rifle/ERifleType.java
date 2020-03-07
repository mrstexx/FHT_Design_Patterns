package edu.dp.rifle;

public enum ERifleType {
    ASSAULT("assault"),
    SNIPER("sniper");

    private String type;

    private ERifleType(String type) {
        this.type = type;
    }

    public static String getValue(String code) {
        for (ERifleType rifle : ERifleType.values()) {
            if (rifle.type.equals(code)) {
                return rifle.name();
            }
        }
        return null;
    }

}
