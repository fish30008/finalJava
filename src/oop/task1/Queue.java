package oop.task1;

public interface Queue<T> {
    void enqueue(T element); // Add an element to the queue
    T dequeue();             // Remove and return the first element
    T peek();                // Return the first element without removing
    boolean isEmpty();       // Check if the queue is empty
    int size();              // Get the current size of the queue
}

