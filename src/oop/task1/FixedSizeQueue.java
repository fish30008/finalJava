package oop.task1;

public class FixedSizeQueue<T> implements Queue<T> {
    private Object[] array;
    private int front = 0;
    private int rear = 0;
    private int count = 0;
    private int capacity;

    public FixedSizeQueue(int capacity) {
        this.capacity = capacity;
        this.array = new Object[capacity];
    }

    @Override
    public void enqueue(T element) {
        if (count == capacity) throw new IllegalStateException("Queue is full");
        array[rear] = element;
        rear = (rear + 1) % capacity;
        count++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        T element = (T) array[front];
        front = (front + 1) % capacity;
        count--;
        return element;
    }

    @Override
    public T peek() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        return (T) array[front];
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int size() {
        return count;
    }
}
