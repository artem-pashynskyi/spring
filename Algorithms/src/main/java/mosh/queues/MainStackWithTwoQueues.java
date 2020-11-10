package mosh.queues;

public class MainStackWithTwoQueues {
    public static void main(String[] args) {
        StackWithTwoQueues stackWithTwoQueues = new StackWithTwoQueues();
        stackWithTwoQueues.push(10);
        stackWithTwoQueues.push(20);
        stackWithTwoQueues.push(30);
        stackWithTwoQueues.push(40);
        System.out.println(stackWithTwoQueues);
        System.out.println(stackWithTwoQueues.pop());
        System.out.println(stackWithTwoQueues.pop());
        System.out.println(stackWithTwoQueues.pop());
        System.out.println(stackWithTwoQueues);
        stackWithTwoQueues.push(20);
        stackWithTwoQueues.push(30);
        System.out.println(stackWithTwoQueues);
        System.out.println(stackWithTwoQueues.peek());
        System.out.println(stackWithTwoQueues);
        System.out.println(stackWithTwoQueues.size());
    }
}
