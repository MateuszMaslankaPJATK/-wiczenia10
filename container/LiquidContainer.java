package container;

import exceptions.OverfillException;
import interfaces.IHazardNotifier;

public class LiquidContainer extends BaseContainer implements IHazardNotifier {
    private boolean isHazardous;

    public LiquidContainer(double height, double weight, double depth, double capacity, boolean isHazardous) {
        super(height, weight, depth, capacity, 'L');
        this.isHazardous = isHazardous;
    }

    @Override
    public void load(double mass) throws OverfillException {
        double limit = isHazardous ? 0.5 : 0.9;
        if (mass > capacity * limit) {
            notifyHazard("Attempted overfill: " + mass + "kg in " + getSerialNumber());
            throw new OverfillException("Cannot load " + mass + "kg into " + getSerialNumber());
        }
        cargoWeight = mass;
    }

    @Override
    public void notifyHazard(String message) {
        System.out.println("Hazard ALERT [Liquid]: " + message);
    }
}
