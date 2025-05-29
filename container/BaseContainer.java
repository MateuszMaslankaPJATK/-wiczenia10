package container;

import exceptions.OverfillException;

public abstract class BaseContainer {
    private static int serialCounter = 1;

    protected double height;
    protected double weight;
    protected double depth;
    protected double capacity;
    protected double cargoWeight;
    protected String serialNumber;

    public BaseContainer(double height, double weight, double depth, double capacity, char typeChar) {
        this.height = height;
        this.weight = weight;
        this.depth = depth;
        this.capacity = capacity;
        this.cargoWeight = 0;
        this.serialNumber = generateSerial(typeChar);
    }

    private String generateSerial(char typeChar) {
        return "KON-" + typeChar + "-" + serialCounter++;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void unload() {
        cargoWeight = 0;
    }

    public abstract void load(double mass) throws OverfillException;

    public double getCargoWeight() {
        return cargoWeight;
    }

    public double getTotalWeight() {
        return cargoWeight + weight;
    }

    @Override
    public String toString() {
        return serialNumber + " (cargo=" + cargoWeight + "kg)";
    }
}
