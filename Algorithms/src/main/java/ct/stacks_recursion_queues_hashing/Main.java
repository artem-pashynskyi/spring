package ct.stacks_recursion_queues_hashing;

public class Main {
    public static void main(String[] args) {
        LinkedListQueue linkedListQueue = new LinkedListQueue();
        linkedListQueue.enqueue(10);
        linkedListQueue.enqueue(20);
        linkedListQueue.enqueue(30);
        linkedListQueue.enqueue(40);
        linkedListQueue.enqueue(50);
        System.out.println("***print***");
        linkedListQueue.print();
        System.out.println("***dequeue***");
        System.out.println(linkedListQueue.dequeue());
        System.out.println("***print***");
        linkedListQueue.print();
        System.out.println("***size***");
        System.out.println(linkedListQueue.size());
        System.out.println("***peek***");
        System.out.println(linkedListQueue.peek());
    }
}
