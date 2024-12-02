package oop.task4;

import oop.Car;
import oop.CarLoader;
import oop.task2.ElectricStation;
import oop.task2.GasStation;
import oop.task2.PeopleDinner;
import oop.task2.RobotDinner;
import oop.task3.Concept;

import java.io.IOException;
import java.util.List;

import java.io.IOException;
import java.util.List;

public class SemaphoreTest extends Concept {
    public static void main(String[] args) {
        try {
            SemaphoreTest test = new SemaphoreTest();
            test.run();
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            // Load cars
            String folderPath = "queue"; // Folder where Car JSON files are stored
            List<Car> loadedCars = CarLoader.loadCars(folderPath);

            // Route cars using semaphore
            for (Car car : loadedCars) {
                try {
                    semaphore.routeCar(car);
                } catch (Exception e) {
                    System.err.println("Error routing car: " + car + ". " + e.getMessage());
                }
            }

            // Serve cars from each station
            try {
                System.out.println("Serving cars at Electric-People Station:");
                electricPeopleStation.serveCars();
            } catch (Exception e) {
                System.err.println("Error serving cars at Electric-People Station: " + e.getMessage());
            }

            try {
                System.out.println("Serving cars at Gas-People Station:");
                gasPeopleStation.serveCars();
            } catch (Exception e) {
                System.err.println("Error serving cars at Gas-People Station: " + e.getMessage());
            }

            try {
                System.out.println("Serving cars at Electric-Robots Station:");
                electricRobotsStation.serveCars();
            } catch (Exception e) {
                System.err.println("Error serving cars at Electric-Robots Station: " + e.getMessage());
            }

            try {
                System.out.println("Serving cars at Gas-Robots Station:");
                gasRobotsStation.serveCars();
            } catch (Exception e) {
                System.err.println("Error serving cars at Gas-Robots Station: " + e.getMessage());
            }

            // Print final statistics
            System.out.println("\nFinal Statistics:");
            System.out.println("Electric cars refueled: " + ElectricStation.getElectricCount());
            System.out.println("Gas cars refueled: " + GasStation.getGasCount());
            System.out.println("People served dinner: " + PeopleDinner.getPeopleCount());
            System.out.println("Robots served dinner: " + RobotDinner.getRobotCount());
        } catch (IOException e) {
            System.err.println("Error during car loading or processing: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("An unexpected error occurred in run(): " + e.getMessage());
            e.printStackTrace();
        }
    }
}

