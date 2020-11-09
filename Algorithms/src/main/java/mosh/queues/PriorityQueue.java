package mosh.queues;

import java.util.Arrays;

public class PriorityQueue {

    int[] items;
    int count;

    public PriorityQueue(int capacity) {
        items = new int[capacity];
    }

    //[1, 3, 5, 7] - insert 2
    public void add(int item) {
        if(isFull())
            throw new IllegalStateException();
        if(isEmpty())
            items[count] = item;
        else {
            int i;
            for(i = count-1 ; i >= 0 ; i--) {
                if(items[i] > item) {
                    items[i+1] = items[i];
                } else {
                    break;
                }
            }
            items[i+1] = item;
        }
        count++;
    }

    public int remove() {
        if(isEmpty())
            throw new IllegalStateException();
        return items[--count];
    }

    public boolean isFull() {
        return count == items.length;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public String toString() {
        return "PriorityQueue{" +
                "items=" + Arrays.toString(items) +
                '}';
    }
}
