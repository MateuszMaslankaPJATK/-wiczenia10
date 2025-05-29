package ship;

import container.BaseContainer;

import java.util.ArrayList;
import java.util.List;

public class ContainerShip {
    private String name;
    private double maxSpeed;
    private int maxContainers;
    private double maxWeight;
    private List<BaseContainer> containers;

    public ContainerShip(String name, double maxSpeed, int maxContainers, double maxWeight) {
        this.name = name;
        this.maxSpeed = maxSpeed;
        this.maxContainers = maxContainers;
        this.maxWeight = maxWeight;
        this.containers = new ArrayList<>();
    }

    public void loadContainer(BaseContainer container) {
        if (containers.size() >= maxContainers) {
            throw new IllegalStateException("Ship is full.");
        }
        double totalWeight = containers.stream().mapToDouble(BaseContainer::getTotalWeight).sum();
        if (totalWeight + container.getTotalWeight() > maxWeight * 1000) {
            throw new IllegalStateException("Exceeding weight limit.");
        }
        containers.add(container);
    }

    public void unloadContainer(String serial) {
        containers.removeIf(c -> c.getSerialNumber().equals(serial));
    }

    public void replaceContainer(String serial, BaseContainer newContainer) {
        for (int i = 0; i < containers.size(); i++) {
            if (containers.get(i).getSerialNumber().equals(serial)) {
                containers.set(i, newContainer);
                return;
            }
        }
        throw new IllegalArgumentException("Container not found.");
    }

    public void transferContainerTo(String serial, ContainerShip targetShip) {
        for (BaseContainer c : containers) {
            if (c.getSerialNumber().equals(serial)) {
                targetShip.loadContainer(c);
                containers.remove(c);
                return;
            }
        }
        throw new IllegalArgumentException("Container not found.");
    }

    public void printInfo() {
        System.out.println("Ship: " + name + ", speed=" + maxSpeed + " knots");
        containers.forEach(System.out::println);
    }
}
