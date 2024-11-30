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

public class SemaphoreTest extends Concept {
    public static void main(String[] args) throws IOException {
        SemaphoreTest test = new SemaphoreTest();
        test.run();
    }

    public void run() throws IOException {
        // Load cars
        String folderPath = "queue"; // Folder where Car JSON files are stored
        List<Car> loadedCars = CarLoader.loadCars(folderPath);

        // Route cars using semaphore
        for (Car car : loadedCars) {
            semaphore.routeCar(car);
        }

        // Serve cars from each station
        System.out.println("Serving cars at Electric-People Station:");
        electricPeopleStation.serveCars();
        System.out.println("Serving cars at Gas-People Station:");
        gasPeopleStation.serveCars();
        System.out.println("Serving cars at Electric-Robots Station:");
        electricRobotsStation.serveCars();
        System.out.println("Serving cars at Gas-Robots Station:");
        gasRobotsStation.serveCars();

        // Print final statistics
        System.out.println("\nFinal Statistics:");
        System.out.println("Electric cars refueled: " + ElectricStation.getElectricCount());
        System.out.println("Gas cars refueled: " + GasStation.getGasCount());
        System.out.println("People served dinner: " + PeopleDinner.getPeopleCount());
        System.out.println("Robots served dinner: " + RobotDinner.getRobotCount());
    }
}
