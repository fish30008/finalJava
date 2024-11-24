package oop.task4;

import oop.Car;
import oop.task1.ArrayListQueue;

public class Semaphore {
    private final ArrayListQueue<Car> electricPeopleQueue;
    private final ArrayListQueue<Car> gasPeopleQueue;
    private final ArrayListQueue<Car> electricRobotsQueue;
    private final ArrayListQueue<Car> gasRobotsQueue;

    public Semaphore(
            ArrayListQueue<Car> electricPeopleQueue,
            ArrayListQueue<Car> gasPeopleQueue,
            ArrayListQueue<Car> electricRobotsQueue,
            ArrayListQueue<Car> gasRobotsQueue
    ) {
        this.electricPeopleQueue = electricPeopleQueue;
        this.gasPeopleQueue = gasPeopleQueue;
        this.electricRobotsQueue = electricRobotsQueue;
        this.gasRobotsQueue = gasRobotsQueue;
    }

    public void routeCar(Car car) {
        if (car.getType().equals("ELECTRIC") && car.getPassengers().equals("PEOPLE")) {
            electricPeopleQueue.enqueue(car);
        } else if (car.getType().equals("GAS") && car.getPassengers().equals("PEOPLE")) {
            gasPeopleQueue.enqueue(car);
        } else if (car.getType().equals("ELECTRIC") && car.getPassengers().equals("ROBOTS")) {
            electricRobotsQueue.enqueue(car);
        } else if (car.getType().equals("GAS") && car.getPassengers().equals("ROBOTS")) {
            gasRobotsQueue.enqueue(car);
        } else {
            System.out.println("No matching station for car: " + car);
        }
    }
}
