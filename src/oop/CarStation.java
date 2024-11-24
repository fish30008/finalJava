package oop;


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

            // Serve dinner if needed
            if (car.isDining()) {
                if (car.getPassengers().equals("PEOPLE")) {
                    diningService.serveDinner(String.valueOf(car.getId()));
                } else if (car.getPassengers().equals("ROBOTS")) {
                    diningService.serveDinner(String.valueOf(car.getId()));
                }
            }

            // Refuel the car
            refuelingService.refuel(String.valueOf(car.getId()));

            System.out.println("Car served: " + car);
        }
    }
    public void addCars(Car car){
        queue.enqueue(car);
        System.out.println("Car added to queue: " + car);
    }
}
