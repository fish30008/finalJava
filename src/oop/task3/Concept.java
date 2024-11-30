package oop.task3;

import oop.Car;
import oop.task1.ArrayListQueue;
import oop.task2.*;
import oop.task4.Semaphore;

public class Concept {
    protected ArrayListQueue<Car> electricPeopleQueue;
    protected ArrayListQueue<Car> gasPeopleQueue;
    protected ArrayListQueue<Car> electricRobotsQueue;
    protected ArrayListQueue<Car> gasRobotsQueue;

    protected Semaphore semaphore;

    protected Dineable peopleDinner;
    protected Dineable robotDinner;
    protected Refuelable electricStation;
    protected Refuelable gasStation;

    protected CarStation electricPeopleStation;
    protected CarStation gasPeopleStation;
    protected CarStation electricRobotsStation;
    protected CarStation gasRobotsStation;

    public Concept() {
        // Initialize queues
        electricPeopleQueue = new ArrayListQueue<>();
        gasPeopleQueue = new ArrayListQueue<>();
        electricRobotsQueue = new ArrayListQueue<>();
        gasRobotsQueue = new ArrayListQueue<>();

        // Initialize semaphore
        semaphore = new Semaphore(
                electricPeopleQueue,
                gasPeopleQueue,
                electricRobotsQueue,
                gasRobotsQueue
        );

        // Initialize dining and refueling services
        peopleDinner = new PeopleDinner();
        robotDinner = new RobotDinner();
        electricStation = new ElectricStation();
        gasStation = new GasStation();

        // Initialize car stations
        electricPeopleStation = new CarStation(peopleDinner, electricStation, electricPeopleQueue);
        gasPeopleStation = new CarStation(peopleDinner, gasStation, gasPeopleQueue);
        electricRobotsStation = new CarStation(robotDinner, electricStation, electricRobotsQueue);
        gasRobotsStation = new CarStation(robotDinner, gasStation, gasRobotsQueue);
    }
}
