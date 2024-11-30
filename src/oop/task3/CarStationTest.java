package oop.task3;

import oop.Car;
import oop.CarLoader;

import java.io.IOException;
import java.util.List;

public class CarStationTest extends Concept {
    public static void main(String[] args) throws IOException {
        CarStationTest test = new CarStationTest();
        test.run();
    }

    public void run() throws IOException {
        // Load cars
        String folderPath = "queue"; // Folder where Car JSON files are stored
        List<Car> loadedCars = CarLoader.loadCars(folderPath);

        // Route cars to the appropriate stations
        for (Car car : loadedCars) {
            if (car.getType().equals("ELECTRIC") && car.getPassengers().equals("PEOPLE")) {
                electricPeopleStation.addCars(car);
            } else if (car.getType().equals("GAS") && car.getPassengers().equals("PEOPLE")) {
                gasPeopleStation.addCars(car);
            } else if (car.getType().equals("GAS") && car.getPassengers().equals("ROBOTS")) {
                gasRobotsStation.addCars(car);
            } else if (car.getType().equals("ELECTRIC") && car.getPassengers().equals("ROBOTS")) {
                electricRobotsStation.addCars(car);
            } else {
                System.out.println("No matching station for car: " + car);
            }
        }

        // Serve cars
        System.out.println("Serving cars at Electric-People Station:");
        electricPeopleStation.serveCars();
        System.out.println("Serving cars at Gas-People Station:");
        gasPeopleStation.serveCars();
        System.out.println("Serving cars at Electric-Robots Station:");
        electricRobotsStation.serveCars();
        System.out.println("Serving cars at Gas-Robots Station:");
        gasRobotsStation.serveCars();

        // Check if all queues are empty
        System.out.println("\nAre all queues empty?");
        System.out.println("Electric People Queue: " + electricPeopleQueue.isEmpty());
        System.out.println("Gas People Queue: " + gasPeopleQueue.isEmpty());
        System.out.println("Electric Robots Queue: " + electricRobotsQueue.isEmpty());
        System.out.println("Gas Robots Queue: " + gasRobotsQueue.isEmpty());
    }
}
