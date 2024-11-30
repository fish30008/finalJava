package oop.task3;


import oop.Car;
import oop.task1.ArrayListQueue;
import oop.task2.Dineable;
import oop.task2.Refuelable;

public class  CarStation {
    private Dineable diningService;
    private Refuelable refuelingService;
    private ArrayListQueue<Car> queue;


    public CarStation(Dineable diningService, Refuelable refuelingService, ArrayListQueue<Car> queue) {
        this.diningService = diningService;
        this.refuelingService = refuelingService;
        this.queue = queue;
    }


    public void serveCars(){
        while (!queue.isEmpty()) {
            Car car = queue.dequeue(); // Dequeue the first car
            if (car.isDining()) {
                diningService.serveDinner(String.valueOf(car.getId()));
            }
            refuelingService.refuel(String.valueOf(car.getId()));

            System.out.println("Car served: " + car);
        }
    }
    public void addCars(Car car){
        queue.enqueue(car);
        System.out.println("Car added to queue: " + car);
    }
}
