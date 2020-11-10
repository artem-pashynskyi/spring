package mosh.queues;

import java.util.ArrayDeque;
import java.util.Queue;

public class StackWithTwoQueues {
    private Queue<Integer> queue = new ArrayDeque<>();
    private Queue<Integer> queue2 = new ArrayDeque<>();

    public void push(int item) {
        queue.add(item);
    }

    public int pop() {
        while (queue.size() != 1)
            queue2.add(queue.remove());

        var last = queue.remove();
        while (!queue2.isEmpty())
            queue.add(queue2.remove());

        return last;
    }

    public int peek() {
        while (queue.size() != 1)
            queue2.add(queue.remove());

        int last = queue.remove();
        queue2.add(last);
        while (!queue2.isEmpty())
            queue.add(queue2.remove());

        return last;
    }

    public int size() {
        return queue.size();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public String toString() {
        return "StackWithTwoQueues{" +
                "queue=" + queue +
                '}';
    }
}
