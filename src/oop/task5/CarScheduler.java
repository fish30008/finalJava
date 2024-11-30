package oop.task5;

import oop.Car;
import oop.CarLoader;
import oop.task3.Concept;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CarScheduler extends Concept {
    public static void main(String[] args) {
        CarScheduler scheduler = new CarScheduler();
        scheduler.run();
    }

    public void run() {
        try {
            String folderPath = "queue"; // Ensure this folder exists with Car JSON files
            List<Car> cars = CarLoader.loadCars(folderPath);

            ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

            scheduler.scheduleAtFixedRate(new Runnable() {
                private int currentIndex = 0;

                @Override
                public void run() {
                    if (currentIndex < cars.size()) {
                        Car car = cars.get(currentIndex);
                        currentIndex++;

                        System.out.println("Processing car: " + car);

                        // Route and serve the car
                        semaphore.routeCar(car);
                        serveCars();
                    } else {
                        System.out.println("All cars processed. Shutting down scheduler...");
                        scheduler.shutdown();
                    }
                }

                private void serveCars() {
                    if (!electricPeopleQueue.isEmpty()) {
                        electricPeopleStation.serveCars();
                    }
                    if (!gasPeopleQueue.isEmpty()) {
                        gasPeopleStation.serveCars();
                    }
                    if (!electricRobotsQueue.isEmpty()) {
                        electricRobotsStation.serveCars();
                    }
                    if (!gasRobotsQueue.isEmpty()) {
                        gasRobotsStation.serveCars();
                    }
                }
            }, 0, 3, TimeUnit.SECONDS);

            // Keep the program alive
            Thread.currentThread().join();
        } catch (IOException | InterruptedException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
