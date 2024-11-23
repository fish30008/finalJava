package oop.task2;
import oop.CarLoader;
import oop.Car;

import java.io.IOException;
import java.util.List;

public class Task2Test {
    public static void main(String[] args) throws IOException {
        // Load cars from JSON files
        String folderPath = "queue"; // Update this with your actual JSON folder path
        List<Car> cars = CarLoader.loadCars(folderPath);

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
