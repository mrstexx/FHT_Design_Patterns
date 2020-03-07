package edu.dp.rifle;

public class SniperRifle extends Rifle {

    private double scopeSize;
    private boolean silencerSupport;

    public SniperRifle(int magazineSize, double hitPoints, double weight, double length, double caliber, String modelName,
                       double scopeSize, boolean silencerSupport) {
        super(magazineSize, hitPoints, weight, length, caliber, modelName);
        this.scopeSize = scopeSize;
        this.silencerSupport = silencerSupport;
    }

    public double getScopeSize() {
        return scopeSize;
    }

    public void setScopeSize(double scopeSize) {
        this.scopeSize = scopeSize;
    }

    public boolean isSilencerSupport() {
        return silencerSupport;
    }

    public void setSilencerSupport(boolean silencerSupport) {
        this.silencerSupport = silencerSupport;
    }

    public SniperRifle clone() throws CloneNotSupportedException {
        return (SniperRifle) super.clone();
    }
}