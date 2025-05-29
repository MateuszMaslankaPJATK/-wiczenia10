package container;

import exceptions.OverfillException;

public class RefrigeratedContainer extends BaseContainer {
    private String productType;
    private double requiredTemp;
    private double containerTemp;

    public RefrigeratedContainer(double height, double weight, double depth, double capacity, String productType, double requiredTemp, double containerTemp) {
        super(height, weight, depth, capacity, 'C');
        this.productType = productType;
        this.requiredTemp = requiredTemp;
        this.containerTemp = containerTemp;
    }

    @Override
    public void load(double mass) throws OverfillException {
        if (mass > capacity) {
            throw new OverfillException("Refrigerated container overloaded.");
        }
        if (containerTemp < requiredTemp) {
            throw new IllegalArgumentException("Container temperature too low.");
        }
        cargoWeight = mass;
    }

    public String getProductType() {
        return productType;
    }

    public double getContainerTemp() {
        return containerTemp;
    }
}
