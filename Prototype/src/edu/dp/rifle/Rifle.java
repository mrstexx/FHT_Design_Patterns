package edu.dp.rifle;

public abstract class Rifle implements Cloneable {

    private int magazineSize;
    private double hitPoints;
    private double weight;
    private double length;
    private double caliber;
    private String modelName;

    public Rifle(int magazineSize, double hitPoints, double weight, double length, double caliber, String modelName) {
        this.magazineSize = magazineSize;
        this.hitPoints = hitPoints;
        this.weight = weight;
        this.length = length;
        this.caliber = caliber;
        this.modelName = modelName;
    }

    public int getMagazineSize() {
        return magazineSize;
    }

    public void setMagazineSize(int magazineSize) {
        this.magazineSize = magazineSize;
    }

    public double getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(double hitPoints) {
        this.hitPoints = hitPoints;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getCaliber() {
        return caliber;
    }

    public void setCaliber(double caliber) {
        this.caliber = caliber;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Rifle clone() throws CloneNotSupportedException {
        return (Rifle) super.clone();
    }
}
