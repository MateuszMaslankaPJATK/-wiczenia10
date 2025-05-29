package container;

import exceptions.OverfillException;
import interfaces.IHazardNotifier;

public class GasContainer extends BaseContainer implements IHazardNotifier {
    private double pressure;

    public GasContainer(double height, double weight, double depth, double capacity, double pressure) {
        super(height, weight, depth, capacity, 'G');
        this.pressure = pressure;
    }

    @Override
    public void load(double mass) throws OverfillException {
        if (mass > capacity) {
            notifyHazard("Overfill in gas container " + getSerialNumber());
            throw new OverfillException("Gas container overloaded.");
        }
        cargoWeight = mass;
    }

    @Override
    public void unload() {
        cargoWeight *= 0.05;  // Leave 5% inside
    }

    @Override
    public void notifyHazard(String message) {
        System.out.println("Hazard ALERT [Gas]: " + message);
    }
}
