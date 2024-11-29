package oop.task5;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import oop.Car;
import oop.CarLoader;
import oop.task1.ArrayListQueue;
import oop.task3.CarStation;
import oop.task4.*;
import oop.task2.*;

    public class CarScheduler {
        public static void main(String[] args) {
            // Step 1: Initialize CarStations and Semaphore
            ArrayListQueue<Car> electricPeopleQueue = new ArrayListQueue<>();
            ArrayListQueue<Car> gasPeopleQueue = new ArrayListQueue<>();
            ArrayListQueue<Car> electricRobotsQueue = new ArrayListQueue<>();
            ArrayListQueue<Car> gasRobotsQueue = new ArrayListQueue<>();

            Semaphore semaphore = new Semaphore(
                    electricPeopleQueue,
                    gasPeopleQueue,
                    electricRobotsQueue,
                    gasRobotsQueue
            );

            Dineable peopleDinner = new PeopleDinner();
            Dineable robotDinner = new RobotDinner();
            Refuelable electricStation = new ElectricStation();
            Refuelable gasStation = new GasStation();

            CarStation electricPeopleStation = new CarStation(peopleDinner, electricStation, electricPeopleQueue);
            CarStation gasPeopleStation = new CarStation(peopleDinner, gasStation, gasPeopleQueue);
            CarStation electricRobotsStation = new CarStation(robotDinner, electricStation, electricRobotsQueue);
            CarStation gasRobotsStation = new CarStation(robotDinner, gasStation, gasRobotsQueue);

            // Step 2: Load all cars once
            List<Car> cars;
            try {
                String folderPath = "queue"; // Ensure this folder exists with Car JSON files
                cars = CarLoader.loadCars(folderPath);
            } catch (IOException e) {
                System.err.println("Error loading cars: " + e.getMessage());
                return; // Exit if cars cannot be loaded
            }

            // Step 3: Create Scheduler
            ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

            // Step 4: Process cars one by one
            scheduler.scheduleAtFixedRate(new Runnable() {
                private int currentIndex = 0;

                @Override
                public void run() {
                    if (currentIndex < cars.size()) {
                        Car car = cars.get(currentIndex);
                        currentIndex++;

                        System.out.println("Processing car: " + car);

                        // Route the car to the correct station
                        semaphore.routeCar(car);

                        // Serve the car
                        if (!electricPeopleQueue.isEmpty()) {
                            electricPeopleStation.serveCars();
                        } else if (!gasPeopleQueue.isEmpty()) {
                            gasPeopleStation.serveCars();
                        } else if (!electricRobotsQueue.isEmpty()) {
                            electricRobotsStation.serveCars();
                        } else if (!gasRobotsQueue.isEmpty()) {
                            gasRobotsStation.serveCars();
                        }
                    } else {
                        System.out.println("All cars processed. Shutting down scheduler...");
                        scheduler.shutdown();
                    }
                }
            }, 0, 3, TimeUnit.SECONDS); // Run every 3 seconds

            // Step 5: Keep the program alive
            try {
                System.out.println("Scheduler is running. Press Ctrl+C to terminate.");
                Thread.currentThread().join(); // Block main thread indefinitely
            } catch (InterruptedException e) {
                System.out.println("Main thread interrupted, shutting down...");
                scheduler.shutdown();
            }
        }
    }



