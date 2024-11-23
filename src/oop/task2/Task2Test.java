package oop.task2;
import oop.Car;
import oop.Dineable;
import oop.Refuelable;

import java.util.ArrayList;
import java.util.List;

public class Task2Test {
    public static void main(String[] args) {
        // Test data
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(1, "ELECTRIC", "PEOPLE", false, 42));
        cars.add(new Car(2, "GAS", "ROBOTS", true, 35));
        cars.add(new Car(3, "ELECTRIC", "ROBOTS", true, 40));
        cars.add(new Car(4, "GAS", "PEOPLE", false, 20));

        // Implementations
        Refuelable electricStation = new ElectricStation();
        Refuelable gasStation = new GasStation();
        Dineable peopleDinner = new PeopleDinner();
        Dineable robotDinner = new RobotDinner();

        // Process each car
        for (Car car : cars) {
            String carId = String.valueOf(car.getId());

            // Refuel based on car type
            if (car.getType().equals("ELECTRIC")) {
                electricStation.refuel(carId);
            } else if (car.getType().equals("GAS")) {
                gasStation.refuel(carId);
            }

            // Serve dinner based on passenger type
            if (car.isDining()) {
                if (car.getPassengers().equals("PEOPLE")) {
                    peopleDinner.serveDinner(carId);
                } else if (car.getPassengers().equals("ROBOTS")) {
                    robotDinner.serveDinner(carId);
                }
            }
        }

        // Print statistics
        System.out.println("\nStatistics:");
        System.out.println("Electric cars refueled: " + ElectricStation.getElectricCount());
        System.out.println("Gas cars refueled: " + GasStation.getGasCount());
        System.out.println("People served dinner: " + PeopleDinner.getPeopleCount());
        System.out.println("Robots served dinner: " + RobotDinner.getRobotCount());
    }
}
