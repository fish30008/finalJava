package oop.task1;
import java.util.ArrayList;

public class ArrayListQueue<T> implements Queue<T> {
    private ArrayList<T> list = new ArrayList<>();

    @Override
    public void enqueue(T element) {
        list.add(element);
    }

    @Override
    public T dequeue() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        return list.remove(0);
    }

    @Override
    public T peek() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        return list.get(0);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }
}
