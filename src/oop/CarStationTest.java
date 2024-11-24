package oop;

import oop.task1.ArrayListQueue;
import oop.task2.*;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

public class CarStationTest {
    public static void main(String[] args) throws IOException {
        // Step 1: Load cars using CarLoader
        String folderPath = "queue"; // Folder where Car JSON files are stored
        List<Car> loadedCars = CarLoader.loadCars(folderPath);
        // Step 2: Create queues using ArrayListQueue
        ArrayListQueue<Car> electricPeopleQueue = new ArrayListQueue<>();
        ArrayListQueue<Car> gasRobotsQueue = new ArrayListQueue<>();
        ArrayListQueue<Car> electricRobotsQueue = new ArrayListQueue<>();
        ArrayListQueue<Car> gasPeopleQueue = new ArrayListQueue<>();


        // Step 3: Create dining and refueling services
        Dineable peopleDinner = new PeopleDinner();
        Dineable robotDinner = new RobotDinner();
        Refuelable electricStation = new ElectricStation();
        Refuelable gasStation = new GasStation();

        // Step 4: Create CarStations
        CarStation electricPeopleStation = new CarStation(peopleDinner, electricStation, electricPeopleQueue);
        CarStation gasRobotsStation = new CarStation(robotDinner, gasStation, gasRobotsQueue);
        CarStation electricRobotsStation = new CarStation(robotDinner, electricStation, electricRobotsQueue);
        CarStation gasPeopleStation = new CarStation(peopleDinner, gasStation, gasPeopleQueue);

        // Step 5: Distribute cars to appropriate stations
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

        // Step 6: Serve cars from each station
        System.out.println("Serving cars at Electric-People Station:");
        electricPeopleStation.serveCars();
        System.out.println("Serving cars at Gas-People Station:");
        gasPeopleStation.serveCars();
        System.out.println("Serving cars at Electric-Robotos Station:");
        electricRobotsStation.serveCars();
        System.out.println("Serving cars at gas-Robots Station:");
        gasRobotsStation.serveCars();


        // Step 7: Validate statistics
        System.out.println("\nFinal Statistics:");
        System.out.println("Electric cars refueled: " + ElectricStation.getElectricCount());
        System.out.println("Gas cars refueled: " + GasStation.getGasCount());
        System.out.println("People served dinner: " + PeopleDinner.getPeopleCount());
        System.out.println("Robots served dinner: " + RobotDinner.getRobotCount());
    }
}

