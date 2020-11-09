package mosh.queues;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayQueue {

    private int[] queue;
    private int last, first, count;

    public ArrayQueue(int capacity) {
        queue = new int[capacity];
    }

    /*
    Circular array: 0 0 30 40 50
    int circular_index = 0 % queue.length = 0;
    int circular_index = 1 % queue.length = 1;
    int circular_index = 2 % queue.length = 2;
    int circular_index = 3 % queue.length = 3;
    int circular_index = 4 % queue.length = 4;
    int circular_index = 5 % queue.length = 0;
    int circular_index = 6 % queue.length = 1;
    int circular_index = 7 % queue.length = 2;
    int circular_index = 8 % queue.length = 3;
    int circular_index = 9 % queue.length = 4;
    int circular_index = 10 % queue.length = 0;
     */
    public void enqueue(int item) {
        if(isFull())
            throw new IllegalStateException();
        queue[last] = item;
        last = (last + 1) % queue.length;
        count++;
    }

    public int dequeue() {
        if(isEmpty())
            throw new NoSuchElementException();
        var temp = queue[first];
        queue[first] = 0;
        first = (first + 1) % queue.length;
        count--;
        return temp;
    }

    public int peek() {
        return queue[first];
    }

    public boolean isFull() {
        return count == queue.length;
    }

    public boolean isEmpty() { return count == 0; }

    @Override
    public String toString() {
        return "ArrayQueue{" +
                "queue=" + Arrays.toString(queue) +
                '}';
    }
}
