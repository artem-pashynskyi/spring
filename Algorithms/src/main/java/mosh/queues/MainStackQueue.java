package mosh.queues;

public class MainStackQueue {
    public static void main(String[] args) {
        StackQueue stackQueue = new StackQueue();
        stackQueue.enqueue(10);
        stackQueue.enqueue(20);
        stackQueue.enqueue(30);
        System.out.println(stackQueue.dequeue());
        System.out.println(stackQueue.dequeue());
    }
}
