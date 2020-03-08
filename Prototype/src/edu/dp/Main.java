package edu.dp;

import edu.dp.rifle.AssaultRifle;
import edu.dp.rifle.ERifleType;
import edu.dp.rifle.SniperRifle;

public class Main {

    public static void main(String[] args) {
        AssaultRifle assault = (AssaultRifle) RifleStore.getInstance(ERifleType.ASSAULT.getValue());
        SniperRifle sniper = (SniperRifle) RifleStore.getInstance(ERifleType.SNIPER.getValue());

        if (assault != null) {
            System.out.println(assault.getModelName());
        }
        if (sniper != null) {
            System.out.println(sniper.getModelName());
        }
    }
}