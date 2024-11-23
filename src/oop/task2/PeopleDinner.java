package oop.task2;

public class PeopleDinner implements Dineable {
    private static int peopleCount = 0;

    public static int getPeopleCount() {
        return peopleCount;
    }

    @Override

    public void serveDinner(String carId) {
        peopleCount++;
        System.out.println("Refueling gas car " + carId + ".");
    }
}
