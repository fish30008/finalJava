package oop.task2;

public class ElectricStation implements Refuelable {
    private static int electricCount = 0;

    public static int getElectricCount() {
        return electricCount;
    }

    @Override
    public void refuel(String carId) {
        electricCount ++;
        System.out.println("Refueling electric car " + carId + ".");
    }
}
