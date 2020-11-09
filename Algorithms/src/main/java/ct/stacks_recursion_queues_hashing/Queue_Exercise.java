package ct.stacks_recursion_queues_hashing;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Queue_Exercise {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);
        System.out.println(queue);
        queue = Queue_Exercise.reverse(queue, 4);
        System.out.println(queue);
    }

    /*
    Given an integerK anda queue of integers, write code to reverse the order of the first K elements of the queue.
    -Input:  Q= [10, 20, 30, 40, 50], K = 4
    -Output: Q= [40, 30, 20, 10, 50]
     */

    public static Queue<Integer> reverse(Queue<Integer> queue, int k) {
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> newQueue = new ArrayDeque<>();
        int temp = k;
        while (temp > 0) {
            stack.push(queue.remove());
            temp--;
        }
        temp = k;
        while (temp > 0) {
            newQueue.add(stack.pop());
            temp--;
        }
        while (!queue.isEmpty())
            newQueue.add(queue.remove());

        return newQueue;
    }

}
