package mosh.queues;

public class MainPriorityQueue {
    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue(5);
        priorityQueue.add(5);
        priorityQueue.add(7);
        priorityQueue.add(3);
        priorityQueue.add(1);
        priorityQueue.add(2);
        System.out.println(priorityQueue);
        while(!priorityQueue.isEmpty())
            System.out.println(priorityQueue.remove());
    }
}
