package oop.task1;

public class QueueTests {
    public static void main(String[] args) {
        System.out.println("Testing ArrayListQueue:");
        Queue<Integer> arrayListQueue = new ArrayListQueue<>();
        testQueue(arrayListQueue);

        System.out.println("\nTesting LinkedListQueue:");
        Queue<Integer> linkedListQueue = new LinkedListQueue<>();
        testQueue(linkedListQueue);

        System.out.println("\nTesting DoubleLinkedListQueue:");
        Queue<Integer> doubleLinkedListQueue = new DoubleLinkedListQueue<>();
        testQueue(doubleLinkedListQueue);
    }

    private static void testQueue(Queue<Integer> queue) {
        try {
            // Enqueue elements
            queue.enqueue(10);
            queue.enqueue(20);
            queue.enqueue(30);

            System.out.println("Size after enqueuing 3 elements: " + queue.size());
            System.out.println("Peek first element: " + queue.peek());

            // Dequeue elements
            System.out.println("Dequeued: " + queue.dequeue());
            System.out.println("Dequeued: " + queue.dequeue());

            System.out.println("Peek  " + queue.peek());
            System.out.println("Is empty? " + queue.isEmpty());

            // Final dequeue
            System.out.println("Dequeued: " + queue.dequeue());

            System.out.println("Is empty ?: " + queue.isEmpty());
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}
