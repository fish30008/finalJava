package oop.task2;

public class RobotDinner implements Dineable {
    private static int robotCount = 0;

    public static int getRobotCount() {
        return robotCount;
    }

    @Override
    public void serveDinner(String carId) {
        robotCount++;
        System.out.println("Refueling gas car " + carId + ".");
    }
}
