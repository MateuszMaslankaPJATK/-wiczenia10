import container.*;
import exceptions.OverfillException;
import ship.ContainerShip;

public class Main {
    public static void main(String[] args) {
        try {
            LiquidContainer milk = new LiquidContainer(200, 1000, 300, 10000, false);
            milk.load(8000);

            GasContainer helium = new GasContainer(200, 1000, 300, 5000, 5);
            helium.load(4000);

            RefrigeratedContainer bananas = new RefrigeratedContainer(200, 1000, 300, 8000, "bananas", 3, 5);
            bananas.load(7000);

            ContainerShip ship = new ContainerShip("EverGreen", 20, 10, 40000);
            ship.loadContainer(milk);
            ship.loadContainer(helium);
            ship.loadContainer(bananas);//

            ship.printInfo();

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
