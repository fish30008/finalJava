package oop.task1;
import oop.Car;
import oop.CarLoader;

import java.io.IOException;
import java.util.List;

public class QueueTests {
    public static void main(String[] args) throws IOException {
        String folderPath = "queue";
        List<Car> cars = CarLoader.loadCars(folderPath);

        testQueue(new ArrayListQueue<>(), cars);
        testQueue(new LinkedListQueue<>(), cars);
        testQueue(new FixedSizeQueue<>(30), cars); // Adjust size for fixed queue
    }

    private static void testQueue(Queue<Car> queue, List<Car> cars) {
        System.out.println("Testing " + queue.getClass().getSimpleName());

        // Enqueue all cars
        for (Car car : cars) {
            queue.enqueue(car);
        }

        assert queue.size() == cars.size() : "Size mismatch after enqueueing";

        // Peek and dequeue each car
        for (Car car : cars) {
            assert queue.peek().equals(car) : "Peek mismatch";
            assert queue.dequeue().equals(car) : "Dequeue mismatch";
        }

        assert queue.isEmpty() : "Queue should be empty after dequeueing all elements";

        System.out.println("All tests passed for " + queue.getClass().getSimpleName());
    }
}
