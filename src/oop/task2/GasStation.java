package oop.task2;

public class GasStation implements Refuelable {
    private static int gasCount = 0;

    public static int getGasCount() {
        return gasCount;
    }

    @Override
    public void refuel(String carId) {
        gasCount ++;
        System.out.println("Refueling gas car " + carId + ".");
    }
}