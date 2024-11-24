package oop.task4;

import oop.Car;
import oop.CarLoader;
import oop.task3.CarStation;
import oop.task1.ArrayListQueue;
import oop.task2.*;

import java.io.IOException;
import java.util.List;

public class SemaphoreTest {
    public static void main(String[] args) throws IOException {
        // Step 1: Load cars using CarLoader
        String folderPath = "queue"; // Folder where Car JSON files are stored
        List<Car> loadedCars = CarLoader.loadCars(folderPath);

        // Step 2: Create queues
        ArrayListQueue<Car> electricPeopleQueue = new ArrayListQueue<>();
        ArrayListQueue<Car> gasPeopleQueue = new ArrayListQueue<>();
        ArrayListQueue<Car> electricRobotsQueue = new ArrayListQueue<>();
        ArrayListQueue<Car> gasRobotsQueue = new ArrayListQueue<>();

        // Step 3: Create Semaphore
        Semaphore semaphore = new Semaphore(
                electricPeopleQueue,
                gasPeopleQueue,
                electricRobotsQueue,
                gasRobotsQueue
        );

        // Step 4: Route cars using Semaphore
        for (Car car : loadedCars) {
            semaphore.routeCar(car);
        }

        // Step 5: Create dining and refueling services
        Dineable peopleDinner = new PeopleDinner();
        Dineable robotDinner = new RobotDinner();
        Refuelable electricStation = new ElectricStation();
        Refuelable gasStation = new GasStation();

        // Step 6: Create CarStations
        CarStation electricPeopleStation = new CarStation(peopleDinner, electricStation, electricPeopleQueue);
        CarStation gasPeopleStation = new CarStation(peopleDinner, gasStation, gasPeopleQueue);
        CarStation electricRobotsStation = new CarStation(robotDinner, electricStation, electricRobotsQueue);
        CarStation gasRobotsStation = new CarStation(robotDinner, gasStation, gasRobotsQueue);

        // Step 7: Serve cars from each station
        System.out.println("Serving cars at Electric-People Station:");
        electricPeopleStation.serveCars();
        System.out.println("Serving cars at Gas-People Station:");
        gasPeopleStation.serveCars();
        System.out.println("Serving cars at Electric-Robots Station:");
        electricRobotsStation.serveCars();
        System.out.println("Serving cars at Gas-Robots Station:");
        gasRobotsStation.serveCars();

        // Step 8: Validate statistics
        System.out.println("\nFinal Statistics:");
        System.out.println("Electric cars refueled: " + ElectricStation.getElectricCount());
        System.out.println("Gas cars refueled: " + GasStation.getGasCount());
        System.out.println("People served dinner: " + PeopleDinner.getPeopleCount());
        System.out.println("Robots served dinner: " + RobotDinner.getRobotCount());
    }
}
